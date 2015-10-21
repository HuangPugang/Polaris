package com.hpg.demo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = -7115737618295724591L;
	private int user_id;
	private String user_username;
	private String user_profiles;
	private int user_sex;
	private String user_createtime;
	private String user_portrait_url;
	private String user_password;
	
	public User() {
	}

	
	public User(int userId, String userUsername, String userProfiles,
			int userSex, String userCreatetime, String userPortraitUrl,
			String userPassword) {
		super();
		user_id = userId;
		user_username = userUsername;
		user_profiles = userProfiles;
		user_sex = userSex;
		user_createtime = userCreatetime;
		user_portrait_url = userPortraitUrl;
		user_password = userPassword;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String userUsername) {
		user_username = userUsername;
	}

	public String getUser_profiles() {
		return user_profiles;
	}

	public void setUser_profiles(String userProfiles) {
		user_profiles = userProfiles;
	}

	public int getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(int userSex) {
		user_sex = userSex;
	}

	public String getUser_createtime() {
		return user_createtime;
	}

	public void setUser_createtime(String userCreatetime) {
		user_createtime = userCreatetime;
	}

	public String getUser_portrait_url() {
		return user_portrait_url;
	}

	public void setUser_portrait_url(String userPortraitUrl) {
		user_portrait_url = userPortraitUrl;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}

	
}
