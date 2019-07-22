package com.riadh.farhati.domain;

import java.util.Date;

public class User {
	private Integer id;
	private String firstname;
	private String lastName;
	private String email;
	private  Date birthday;
	private  String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String firstname, String lastName, String email, Date birthday, String password) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
	}
	public User() {
		
	}
	public User(Integer id, String firstname, String lastName, String email, Date birthday, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
	}
	

}
