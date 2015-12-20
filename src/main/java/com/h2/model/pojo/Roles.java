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

@Entity
@Table(name = "roles", catalog="shoedb")
public class Roles implements Serializable{
	private int roleId;
	private String roleName;
	private List<User> userList = new ArrayList<User>(0);
	
	public Roles(){}

	public Roles(int roleId, String roleName, List<User> userList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userList = userList;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleId", unique = true, nullable = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "roleName", nullable = false)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
