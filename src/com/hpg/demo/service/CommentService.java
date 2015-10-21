package com.hpg.demo.service;

import java.util.List;

import com.hpg.demo.bean.Comment;

public interface CommentService {

	public List<Comment> getCommentListByPostId(int postId);
}
