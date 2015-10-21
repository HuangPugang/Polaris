package com.hpg.demo.bean;

import java.util.Arrays;

public class TestBean {
	private String username;
	private String password;
	
	private String[] xingQ;
	
	public String[] getXingQ() {
		return xingQ;
	}
	public void setXingQ(String[] xingQ) {
		this.xingQ = xingQ;
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
	public TestBean() {
		super();
	}
	@Override
	public String toString() {
		return "TestBean [username=" + username + ", password=" + password
				+ ", xingQ=" + Arrays.toString(xingQ) + "]";
	}

	
}
