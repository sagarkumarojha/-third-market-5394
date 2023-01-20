package com.auction.bean;

public class Users {
	private int id;
	private String userName;
	private String Password;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Users(int id, String userName, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.Password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", Password=" + Password + ", role=" + role + "]";
	}

}
