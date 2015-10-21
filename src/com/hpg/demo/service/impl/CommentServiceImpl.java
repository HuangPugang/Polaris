package com.hpg.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpg.demo.bean.Comment;
import com.hpg.demo.dao.CommentMapper;
import com.hpg.demo.service.CommentService;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService{
	@Resource(name="commentMapper")
	private CommentMapper commentMapper;

	public List<Comment> getCommentListByPostId(int postId) {
		return commentMapper.getCommentListByPostId(postId);
	}
	

}
