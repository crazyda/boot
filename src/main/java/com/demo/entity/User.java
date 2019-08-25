package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6334706682134717293L;
	@Id
	@Column
	private String id;
	@Column
	private String login;
	 @Column
	 private String password;
	 @Column
	 private String role;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		
		return "id:"+id+";login:"+login+";password:"+password+";role:"+role;
	}
	 
	
}
