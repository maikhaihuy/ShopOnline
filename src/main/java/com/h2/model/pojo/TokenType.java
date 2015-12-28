package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tokentype", catalog="shoedb")
public class TokenType implements Serializable {
	private int tokenTypeId;
	private String tokenTypeName;
	private List<Token> tokenList = new ArrayList<Token>(0);
	
	public TokenType(){}

	public TokenType(int tokenTypeId, String tokenTypeName,
			List<Token> tokenList) {
		super();
		this.tokenTypeId = tokenTypeId;
		this.tokenTypeName = tokenTypeName;
		this.tokenList = tokenList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tokenTypeId", unique = true, nullable = false)
	public int getTokenTypeId() {
		return tokenTypeId;
	}

	public void setTokenTypeId(int tokenTypeId) {
		this.tokenTypeId = tokenTypeId;
	}

	@Column(name = "tokenTypeName", nullable = false)
	public String getTokenTypeName() {
		return tokenTypeName;
	}

	public void setTokenTypeName(String tokenTypeName) {
		this.tokenTypeName = tokenTypeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tokenType")
	@JsonIgnore
	public List<Token> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List<Token> tokenList) {
		this.tokenList = tokenList;
	}
	
	
}
