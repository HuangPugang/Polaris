package com.hpg.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hpg.demo.bean.Comment;
@Repository("commentMapper")
public interface CommentMapper {
	
	/**
	 * 添加评论
	 * @param comment
	 */
	public void save(Comment comment);
	
	/**
	 * 删除评论
	 */
	public void delete(String comment_id);
	/**
	 * 根据帖子获得评论列表(20条)
	 * @param postId 帖子id
	 */
	public List<Comment> getCommentListByPostId(@Param("postId")int postId);

	/**
	 * 根据帖子id和最后一条评论id加载更多评论(20条)
	 * @param postId 帖子id
	 * @param lastCommentId  最后一条评论id
 	 */
	public List<Comment> getMoreCommentListByPostIdAndLastId(@Param("postId")int postId,@Param("lastCommentId")int lastCommentId);
	
}
