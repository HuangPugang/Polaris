package com.hpg.demo.bean;


public class Comment {
	private int comment_id;
	private String comment_content;
	private String comment_createtime;
	private int user_id;
	private String user_username;
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String userUsername) {
		user_username = userUsername;
	}
	private int post_id;
	private int to_comment_id;
	private int to_user_id;
	
	public Comment(){}
	
	public Comment(int commentId, String commentContent,
			String commentCreatetime, int userId, String userUsername,
			int postId, int toCommentId, int toUserId) {
		super();
		comment_id = commentId;
		comment_content = commentContent;
		comment_createtime = commentCreatetime;
		user_id = userId;
		user_username = userUsername;
		post_id = postId;
		to_comment_id = toCommentId;
		to_user_id = toUserId;
	}

	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int commentId) {
		comment_id = commentId;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String commentContent) {
		comment_content = commentContent;
	}
	public String getComment_createtime() {
		return comment_createtime;
	}
	public void setComment_createtime(String commentCreatetime) {
		comment_createtime = commentCreatetime;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int postId) {
		post_id = postId;
	}
	public int getTo_comment_id() {
		return to_comment_id;
	}
	public void setTo_comment_id(int toCommentId) {
		to_comment_id = toCommentId;
	}
	public int getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(int toUserId) {
		to_user_id = toUserId;
	}
	@Override
	public String toString() {
		return "Comment [comment_content=" + comment_content
				+ ", comment_createtime=" + comment_createtime
				+ ", comment_id=" + comment_id + ", post_id=" + post_id
				+ ", to_comment_id=" + to_comment_id + ", to_user_id="
				+ to_user_id + ", user_id=" + user_id + ", user_username="
				+ user_username + "]";
	}

	
}
