package com.hpg.demo.dao;


import java.util.HashSet;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hpg.demo.bean.User;

@Repository("userMapper")
public interface UserMapper {
	/**
	 * 注册的时候调用这个方法
	 * @param user
	 */
	public void save(User user);

	/**
	 * 获得个人信息
	 * @param userName 用户名
	 * @return
	 */
	public User findUserByUserName(@Param("userName")String userName);
	
	public User findUserByUserNameAndPassword(@Param("userName")String userName,@Param("password")String password);
	
	/**
	 * 更新头像
	 * @param portraitUrl 头像名称
	 * @param userId 用户id
	 */
	public void updatePortrait(@Param("portraitUrl")String portraitUrl,@Param("userId")String userId);
	
	/**
	 * 获得头像名称
	 * @param userId 用户id
	 */
	public String getPortrait(@Param("userId")int userId);
	
	/**
	 * 获得个人信息
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	
	public void updateUserInfo(@Param("userName")String userName,@Param("userSex")int sex,@Param("userProfiles")String profiles);
	
	/**
	 * 找到所有的username
	 * @return
	 */
	public HashSet<String> findAllUserNames();
	
	
}
