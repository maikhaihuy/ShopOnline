package com.h2.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SendMail extends Thread {
	final String pathFile = "/content/";
	private String user;
	private String email;
	private String typeEmail;
	private String subject;
	private String link;
	
	public SendMail(String user, String email, String typeEmail, String subject, String link) {
		this.user = user;
		this.email = email;
		this.typeEmail = typeEmail;
		this.subject = subject;
		this.link = link;
	}
	
	private void SendTo(Session session){
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			
			
			message.setSubject(subject);
			
			String content = readContentFromFile(typeEmail);
			
			content = content.replace("[NAME]", user);
			content = content.replace("[SHOPNAME]", "ShopOnline");
			content = content.replace("[LINK]", link);
			
			message.setContent(content, "text/html; charset=utf-8");
			
			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void run() {
		Session session = configMail();
		if (session != null)
			SendTo(session);
	}
	
	// Read file config
	private Properties readConfig(String classPath){
		Properties prop = null;
		
		try {
			prop = new Properties();
			Resource resource = new ClassPathResource(classPath);
            InputStream input = resource.getInputStream();
            prop.load(input);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		return prop;
	}
	
	private Session configMail(){
		Session session = null;
		Properties propsConfig = readConfig("configMail.properties");
		
		if(propsConfig == null)
			return session;
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", propsConfig.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", propsConfig.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", propsConfig.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", propsConfig.getProperty("mail.smtp.port"));
		
		//Authenticator auth = getAuthenticator(propsConfig.getProperty("mail.username"),propsConfig.getProperty("mail.password"));
		
		//session = Session.getInstance(props,auth);
		final String username = propsConfig.getProperty("mail.username");
		final String password = propsConfig.getProperty("mail.password");
		// Get the Session object.
	    session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

		
		return session;
	}
	
	private Authenticator getAuthenticator(final String username, final String password){
		Authenticator auth = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}};
		return auth;
	}
	
	//Method to read HTML file as a String 
    private String readContentFromFile(String typeEmail) {
        StringBuffer contents = new StringBuffer();

        try {
            //use buffering, reading one line at a time
        	Resource resource = new ClassPathResource(pathFile + typeEmail);
            InputStream ip = resource.getInputStream();
            		
            BufferedReader reader = new BufferedReader(new InputStreamReader(ip, "UTF-8"));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contents.toString();
    }
}
