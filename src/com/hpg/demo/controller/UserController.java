package com.hpg.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpg.demo.bean.User;
import com.hpg.demo.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	@ResponseBody
	public void regist(HttpServletRequest req, HttpServletResponse rep) {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String realname = req.getParameter("realname");
			if (username!=null&&password!=null&&realname!=null&&!"".equals(username) && !"".equals(password)&&!"".equals(realname)) {// 先判断是否为空
				User user = userService.isUserNameExists(username);
				if (user == null) {// 用户为空就可以进行注册了
					User registUser = new User();
					registUser.setUsername(username);// 用户名
					registUser.setPassword(password);// 密码
					registUser.setRealname(realname);
					registUser.setCreatetime(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date()));// 注册时间
					registUser.setId(Integer.parseInt((System
							.currentTimeMillis() + "").substring(5)));// id
					userService.insertUser(registUser);
					sendResponse(rep, getSuccessMessage());
				} else {
					sendResponse(rep, getFailedMessage("账号已经存在"));
				}
			}else {
				sendResponse(rep, getFailedMessage("请输入正确的账号密码"));
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
	 * 登陆验证
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public void login(HttpServletRequest req, HttpServletResponse rep) {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if (!username.equals("") && !password.equals("")) {// 先判断是否为空
				User user = userService.isUernameMatchPassword(username,
						password);
				if (user != null) {// 用户存在
					sendResponse(rep, getSuccessMessage("登陆成功", user));
				} else {// 用户不存在
					sendResponse(rep, getFailedMessage("账号密码不匹配"));
				}
			} else {
				sendResponse(rep, getFailedMessage("请求失败"));
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
