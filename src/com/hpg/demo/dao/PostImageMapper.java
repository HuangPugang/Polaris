package com.hpg.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hpg.demo.bean.PostImageName;


@Repository("postImageMapper")
public interface PostImageMapper {
	
	/**
	 * 根据文章id获得图片名称
	 * @param postId
	 * @return
	 */
	public List<PostImageName> findByPostId(@Param("postId")int postId);
	/**
	 * 找到post对应的图片列表
	 * @param postId
	 * @return
	 */
	public List<PostImageName> findImageByPostId(@Param("postId")int postId);
	/**
	 * 插入图片的名称
	 * @param postId
	 * @param imageNames
	 */
	public void insertImageByPostId(@Param("postId")int postId,@Param("imageName")String imageName);
}
