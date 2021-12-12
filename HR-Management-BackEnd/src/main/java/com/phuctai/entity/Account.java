package com.phuctai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 100)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false)
	private Boolean status;
	
	@Column(nullable = false)
	private Long failNumber;
	
	
	public Account() {
		
	}

	public Account(Long id, String username, String password, Boolean status, Long failNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.failNumber = failNumber;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Long getFailNumber() {
		return failNumber;
	}


	public void setFailNumber(Long failNumber) {
		this.failNumber = failNumber;
	}
	
}
