package com.hpg.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hpg.demo.bean.PostImageName;
import com.hpg.demo.dao.PostImageMapper;
import com.hpg.demo.service.PostImageService;

@Repository("postImageServiceImpl")
public class PostImageServiceImpl implements PostImageService{
	
	@Resource(name="postImageMapper")
	private PostImageMapper postImageMapper;

	public List<PostImageName> findImageByPostId(int postId) {
		// TODO Auto-generated method stub
		return postImageMapper.findByPostId(postId);
	}

	public void insertImageByPostId(int postId, List<String> imageNames) {
		// TODO Auto-generated method stub
		
	}

}
