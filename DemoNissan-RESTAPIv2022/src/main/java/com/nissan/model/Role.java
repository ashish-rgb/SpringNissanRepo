package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TblRole")
public class Role {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	
	//for One Role Many Users
	@JsonIgnore
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL)
	private List<User> users;
	
	//default constructor
	public Role() {}

	//parameterized
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	//getters and setters
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	//@JsonManagedReferences
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	//custom methods
	
	//override toString
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
	
	
	
	
	
}
