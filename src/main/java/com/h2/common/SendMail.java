package com.h2.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SendMail {
	private static Session session;
	final String pathFile = "/content/";
	public SendMail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
         

		session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("suppermagician@gmail.com","m@1kh@1!^@");
				}
			});
	}
	
	public void SendTo(String user, String email, String typeEmail, String subject, String link){
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			
			
			message.setSubject(subject);
			
			String content = readContentFromFile(typeEmail);
			
			content = content.replace("[NAME]", user);
			content = content.replace("[SHOPNAME]", "ShopOnline");
			content = content.replace("[REGISTERLINK]", link);
			
			message.setText(content);
			
			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Method to read HTML file as a String 
    public String readContentFromFile(String typeEmail) {
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
