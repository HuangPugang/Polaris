package com.hpg.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpg.demo.bean.PostImageName;
import com.hpg.demo.bean.Posts;
import com.hpg.demo.dao.PostImageMapper;
import com.hpg.demo.dao.PostsMapper;
import com.hpg.demo.service.PostService;

@Service("postServiceImpl")
public class PostServiceImpl implements PostService {

	@Resource(name = "postMapper")
	private PostsMapper postsMapper;
	@Resource(name = "postImageMapper")
	private PostImageMapper postImageMapper;

	public List<Posts> getHotPostList() {
		List<Posts> list = postsMapper.getHotPostList();
		return setImageNames(list);
	}
	public List<Posts> getHotPostList2() {
		
		return postsMapper.test();
	}
	public List<Posts> getMoreHotPostListByLastId(int lastPostId) {
		List<Posts> list = postsMapper.getMoreHotPostListByLastId(lastPostId);
		return setImageNames(list);
	}

	public List<Posts> getMoreNewPostListByLastId(int lastPostId) {
		List<Posts> list = postsMapper.getMoreNewPostListByLastId(lastPostId);
		return setImageNames(list);
	}

	public List<Posts> getNewPostList() {
		List<Posts> list = postsMapper.getNewPostList();

		return setImageNames(list);
	}

	public Posts getPostContentById(int postId) {
		Posts posts = postsMapper.getPostContentById(postId);
		posts.setPost_image_names(postImageMapper.findByPostId(posts
				.getPost_id()));
		return posts;
	}

	public void addPost(Posts posts) {
		postsMapper.save(posts);
	}

	public List<Posts> setImageNames(List<Posts> list) {
		for (int i = 0; i < list.size(); i++) {
			Posts posts = list.get(i);
			List<PostImageName> l2 =postImageMapper.findImageByPostId(posts
					.getPost_id());
			posts.setPost_image_names(l2);
		}
		return list;
	}

}
