package com.h2.model.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tag", catalog = "shoedb",uniqueConstraints = {@UniqueConstraint(columnNames = "tagName")})
public class Tag implements Serializable{
	private int tagId;
	private String tagName;
	private String tagValue;
	
	public Tag(){}

	public Tag(int tagId, String tagName, String tagValue) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagValue = tagValue;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tagId", unique = true, nullable = false)
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tagName", nullable = false)
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "tagValue", nullable = false)
	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	
	
}
