package com.hpg.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hpg.demo.bean.PostImageName;

public interface PostImageService {
	/**
	 * 根据文章id获得图片名称
	 * @param postId
	 * @return
	 */
	public List<PostImageName> findImageByPostId(int postId);
	
	/**
	 * 插入图片的名称
	 * @param postId
	 * @param imageNames
	 */
	public void insertImageByPostId(int postId,List<String> imageNames);
}
