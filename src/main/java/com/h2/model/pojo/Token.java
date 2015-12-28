package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "token", catalog="shoedb")
public class Token implements Serializable{
	private int tokenId;
	private String tokenString;
	private Date expiryDate;
	private int isVerified;
	private TokenType tokenType;
	private User user;
	
	public Token(){}

	public Token(int tokenId, String tokenString, Date expiryDate,
			int isVerified, TokenType tokenType, User user) {
		super();
		this.tokenId = tokenId;
		this.tokenString = tokenString;
		this.expiryDate = expiryDate;
		this.isVerified = isVerified;
		this.tokenType = tokenType;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tokenId", unique = true, nullable = false)
	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	@Column(name = "tokenString", nullable = false)
	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

	@Column(name = "expiryDate", nullable = false)
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "isVerified", nullable = false)
	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tokenTypeId", nullable = false)
	@JsonIgnore
	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
