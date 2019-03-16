package com.moonis.demo.restapi.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moonis.demo.restapi.common.utils.RandomString;

import lombok.ToString;


@Document(collection = "app_user")@ToString
public class AppUser {
	@Id
    private String id;
	
	@Indexed(unique=true)
	private String username;
	
	@JsonIgnore
	private String password;
	
	private int status;
	
	private String resetoken=RandomString.generateResetoken() ;
	
	@DBRef(lazy=true)
	@JsonIgnore
	private User user;
	
	@DBRef(lazy=false)
	private List<Role> role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResetoken() {
		return resetoken;
	}

	public void setResetoken(String resetoken) {
		this.resetoken = resetoken;
	}

	
}
