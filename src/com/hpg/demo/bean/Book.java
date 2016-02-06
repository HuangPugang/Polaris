package com.hpg.demo.bean;

import com.google.gson.annotations.SerializedName;

public class Book {
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name="";
	@SerializedName("author")
	private String author="";
	@SerializedName("user_id")
	private int userId;
	@SerializedName("createtime")
	private String createtime="";
	@SerializedName("user_name")
	private String userName="";
	@SerializedName("description")
	private String description="";
	
	
	public Book() {
	}


	public Book(String name, String author, int userId, String createTime,
			String userName,String description) {
		this.name = name;
		this.author = author;
		this.userId = userId;
		this.createtime = createTime;
		this.userName = userName;
		this.description = description;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCreateTime() {
		return createtime;
	}


	public void setCreateTime(String createTime) {
		this.createtime = createTime;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
