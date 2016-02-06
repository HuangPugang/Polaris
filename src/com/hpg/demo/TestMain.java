package com.hpg.demo;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
//		System.out.println(JSONUtil.beanListToJSON(postImageMapper.findByPostId(1)));
//		CommentMapper commentMapper = (CommentMapper) ctx.getBean("commentMapper");
//		System.out.println(commentMapper.getCommentListByPostId(1));
//		PostsMapper postsMapper = (PostsMapper) ctx.getBean("postMapper");
//		Posts posts = new Posts(65,null,"大盘跌的一塌糊涂啊。。",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .format(new Date()),0,0,null,null,20150601,"h9911",null);
//		postsMapper.save(posts);
//		System.out.println("椎间盘买个我");
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .format(new Date() ));
//		System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//		List<Posts> posts = postsMapper.getNewPostList();
//		System.out.println(JSONUtil.beanListToJSON(posts));
//		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
//		String s = userMapper.getPortrait(20150601);
//		System.out.println(s);
		try {
			System.out.println(URLEncoder.encode("(ERC)","utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
