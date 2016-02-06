package com.hpg.demo.service;

import java.util.List;

import com.hpg.demo.bean.Book;

public interface BookService {
	
	public void save(Book book);
	public List<Book> getBooks(int startIdex);
	public List<Book> getBooksByUserId(int startIndex,int userId);

}
