package com.hpg.demo.dao;
//package com.hpg.demo.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import com.hpg.demo.bean.Posts;
//
//@Repository("postMapper")
//public interface PostsMapper {
//	/**
//	 * //保存一条数据
//	 * @return
//	 */
//	public void save(Posts posts);
//	/**
//	 * //更新赞的数量
//	 * @return
//	 */
//	public void updateZanNum(Posts posts);
//	/**
//	 * //更新评论数量
//	 * @return
//	 */
//	public void updateContentNum(Posts posts);
//	/**
//	 * //根据id删除帖子
//	 * @return
//	 */
//	public void delete(int postId);
//	/**
//	 * //根据id查找帖子
//	 * @return
//	 */
//	public Posts getPostContentById(@Param("postId")int postId);
//
//	/**
//	 * //查找热门的帖子,20条
//	 * @return
//	 */
//	public List<Posts> getHotPostList();
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
//	
//	public List<Posts> test();
//}
