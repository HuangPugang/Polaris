package com.hpg.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpg.demo.bean.Book;
import com.hpg.demo.service.BookService;

@Controller
@RequestMapping("book")
public class BookController extends BaseController {

	@Resource(name = "bookServiceImpl")
	private BookService bookService;

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public void add(HttpServletRequest req, HttpServletResponse rep) {
		try {
			String name = req.getParameter("name");
			String author = req.getParameter("author");
			String userId = req.getParameter("userid");
			String userName = req.getParameter("username");
			String description = req.getParameter("description");
			String createtime = getTime();
			if (name == null || userId == null || userName == null
					|| createtime == null) {
				sendResponse(rep, getFailedMessage("请输入正确的书名"));
			} else {

				int userid = Integer.parseInt(req.getParameter("userid"));
				Book book = new Book();
				book.setName(name);
				book.setAuthor(author);
				book.setUserId(userid);
				book.setUserName(userName);
				book.setCreateTime(createtime);
				book.setDescription(description);
				bookService.save(book);
				sendResponse(rep, getSuccessMessage());
			}
		} catch (Exception e) {
			try {
				sendResponse(rep, getFailedMessage("服务器响应失败"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * 用户注册
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/books.do", method = RequestMethod.GET)
	@ResponseBody
	public void getBooks(HttpServletRequest req, HttpServletResponse rep) {
		try {
			String page = req.getParameter("page");
			String userId = req.getParameter("userid");
			if (page != null) {
				int p = Integer.parseInt(page);
				int startIndex = p * 20;
				if (userId == null) {
					List<Book> books = bookService.getBooks(startIndex);
					sendResponse(rep, getSuccessMessage(books));
				} else {
					int uid = Integer.parseInt(userId);
					List<Book> books = bookService.getBooksByUserId(startIndex,
							uid);
					sendResponse(rep, getSuccessMessage(books));
				}

			} else {
				sendResponse(rep, getFailedMessage("页数不能为空"));
			}

		} catch (Exception e) {
			try {
				sendResponse(rep, getFailedMessage("服务器响应失败"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * 发送字符串数据
	 * 
	 * @param rep
	 * @param responseMessage
	 * @throws IOException
	 */
	protected void sendResponse(HttpServletResponse rep, String responseMessage)
			throws IOException {
		rep.setContentType(CONTENT_TYPE);
		PrintWriter writer = rep.getWriter();
		writer.println(responseMessage);
		writer.flush();
		writer.close();
	}
}
