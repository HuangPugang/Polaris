package com.hpg.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpg.demo.bean.Book;
import com.hpg.demo.dao.BookMapper;
import com.hpg.demo.service.BookService;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService{
	@Resource(name = "bookMapper")
	private BookMapper bookMapper;

	public List<Book> getBooks(int startIdex) {
		List<Book> list = bookMapper.getBooks(startIdex);
		return list;
	}

	public void save(Book book) {
		bookMapper.save(book);
	}

	public List<Book> getBooksByUserId(int startIndex, int userId) {
		return bookMapper.getBooksByUserId(startIndex, userId);
	}
}
