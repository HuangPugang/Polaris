package com.hpg.demo.service;


import com.hpg.demo.bean.User;



public interface UserService {
	
	/**
	 * 判断用户名是否存在
	 * @param userName 用户名
	 * @return user 存在 null 不存在
	 */
	public User isUserNameExists(String userName);
	
	/**
	 * 判断用户名密码是否匹配
	 * @param userName 用户名
	 * @param password 密码
	 * @return User 匹配  null 不匹配
	 */
	public User isUernameMatchPassword(String userName,String password);
	/**
	 * 插入一条用户信息
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * 登陆后获得个人信息
	 * @param userName
	 * @return 
	 */
	public User findUserByUserName(String userName);
	
	/**
	 * 更新个人信息
	 * @param userId
	 * @param sex
	 * @param profiles
	 */
	public void updateUserInfo(String userName,int sex,String profiles);

	
}
