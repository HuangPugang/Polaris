package com.hpg.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Demo")
public class DemoController {
	@RequestMapping(value = "/validateName.do")
	public void jump(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		if ("huang".equals(request.getParameter("username"))) {

			writer.write("用户名已经存在");
		}else {

			writer.write("注册成功");
		}
		
		writer.flush();
	}
}
