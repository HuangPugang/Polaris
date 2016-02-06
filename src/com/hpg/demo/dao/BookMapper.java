package com.hpg.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hpg.demo.bean.Book;

@Repository("bookMapper")
public interface BookMapper {
	/**
	 * 注册的时候调用这个方法
	 * @param user
	 */
	public void save(Book book);
	
	public List<Book> getBooks(@Param("startIndex") int startIndex);
	
	public List<Book> getBooksByUserId(@Param("startIndex")int startIndex,@Param("userId")int userId);
}
