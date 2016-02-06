package com.hpg.demo.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

	private static final long serialVersionUID = -7115737618295724591L;
	@SerializedName("id")
	private int id;
	@SerializedName("username")
	private String username = "";
	@SerializedName("profiles")
	private String profiles = "";
	@SerializedName("sex")
	private int sex;
	@SerializedName("createtime")
	private String createtime = "";
	@SerializedName("portrait")
	private String portrait = "";
	@SerializedName("realname")
	private String realname;
	private String password;

	public User() {
	}

	public User(int id, String username, String profiles, int sex,
			String createtime, String portrait, String realname, String password) {
		super();
		this.id = id;
		this.username = username;
		this.profiles = profiles;
		this.sex = sex;
		this.createtime = createtime;
		this.portrait = portrait;
		this.realname = realname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
