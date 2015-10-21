package com.hpg.demo.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Posts implements Serializable{

	private static final long serialVersionUID = -8806852281905375929L;
	private int post_id;
	private String post_title;
	private String post_content;
	private String post_createtime;
	private int post_comment_num;
	private int post_favor_num;
	private String post_position_longitude;
	private String post_position_latitude;
	private int user_id;
	private String user_username;
	private String post_position;
	private List<PostImageName> post_image_names;


	public Posts(){}

	public Posts(int post_id, String post_title, String post_content,
			String post_createtime, int post_comment_num, int post_favor_num,
			String post_position_longitude, String post_position_latitude,
			int user_id, String user_username, String post_position,
			List<PostImageName> post_image_names) {
		super();
		this.post_id = post_id;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_createtime = post_createtime;
		this.post_comment_num = post_comment_num;
		this.post_favor_num = post_favor_num;
		this.post_position_longitude = post_position_longitude;
		this.post_position_latitude = post_position_latitude;
		this.user_id = user_id;
		this.user_username = user_username;
		this.post_position = post_position;
		this.post_image_names = post_image_names;
	}




	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String userUsername) {
		user_username = userUsername;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int postId) {
		post_id = postId;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String postTitle) {
		post_title = postTitle;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String postContent) {
		post_content = postContent;
	}

	public String getPost_createtime() {
		return post_createtime;
	}

	public void setPost_createtime(String postCreatetime) {
		post_createtime = postCreatetime;
	}

	public int getPost_comment_num() {
		return post_comment_num;
	}

	public void setPost_comment_num(int postCommentNum) {
		post_comment_num = postCommentNum;
	}

	public int getPost_favor_num() {
		return post_favor_num;
	}

	public void setPost_favor_num(int postFavorNum) {
		post_favor_num = postFavorNum;
	}

	public String getPost_position_longitude() {
		return post_position_longitude;
	}

	public void setPost_position_longitude(String postPositionLongitude) {
		post_position_longitude = postPositionLongitude;
	}

	public String getPost_position_latitude() {
		return post_position_latitude;
	}

	public void setPost_position_latitude(String postPositionLatitude) {
		post_position_latitude = postPositionLatitude;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getPost_position() {
		return post_position;
	}

	public void setPost_position(String postPosition) {
		post_position = postPosition;
	}

	public List<PostImageName> getPost_image_names() {
		return post_image_names;
	}

	public void setPost_image_names(List<PostImageName> post_image_names) {
		this.post_image_names = post_image_names;
	}
	

	
	
	
}
