package com.hpg.demo.bean;

public class PostImage {
	private int id;
	private String image_name;//图片名
	private String user_name;//用户名
	private int post_id;//帖子id
	
	public PostImage(){}
	
	public PostImage(int id, String image_name, String user_name, int post_id) {
		super();
		this.id = id;
		this.image_name = image_name;
		this.user_name = user_name;
		this.post_id = post_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	
}
