package com.hpg.demo.service;
//package com.hpg.demo.service;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Param;
//
//import com.hpg.demo.bean.Posts;
//
//public interface PostService {
//
//	/**
//	 * 获得热门帖子
//	 * @return
//	 */
//	public List<Posts> getHotPostList();
//	/**
//	 * 获得热门帖子
//	 * @return
//	 */
//	public List<Posts> getHotPostList2();
//	/**
//	 * //根据id查找接下来20条热门数据
//	 * @return
//	 */
//	public List<Posts> getMoreHotPostListByLastId(@Param("lastPostId")int lastPostId);
//	/**
//	 * //查找最新的帖子
//	 * @return
//	 */
//	public List<Posts> getNewPostList();
//	
//	/**
//	 * 根据id查找接下来20条最新数据
//	 * @return
//	 */
//	public List<Posts> getMoreNewPostListByLastId(@Param("lastPostId")int lastPostId);
//	
//	/**
//	 * //根据id查找帖子
//	 * @return
//	 */
//	public Posts getPostContentById(int postId);
//	
//	/**
//	 * 添加一篇文章
//	 * @param posts
//	 */
//	public void addPost(Posts posts);
//	
//	
//	
//}
