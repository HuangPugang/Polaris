package com.hpg.demo.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpg.demo.bean.User;
import com.hpg.demo.service.UserService;
import com.hpg.demo.util.JSONUtil;

@Controller
@RequestMapping("User")
public class UserController extends BaseController {

	/** 账号不存在 */
	private static final String ERROR_USERNAME_NOT_EXISTS_RESPONSE = "{\"rc\":0,\"me\":\"账号不存在\"}";
	/** 密码错误 */
	private static final String ERROR_USERNAME_MATCH_PASSWORD_RESPONSE = "{\"rc\":0,\"me\":\"密码错误\"}";
	/** 账号已存在 */
	private static final String ERROR_USERNAME_IS_EXIST_RESPONSE = "{\"rc\":0,\"me\":\"账号已经存在\"}";
	/** 注册成功 */
	private static final String SUCCESS_REGIST_RESPONSE = "{\"rc\":1,\"me\":\"注册成功\"}";
	/** 注册成功 */
	private static final String SUCCESS__RESPONSE = "{\"rc\":1,\"me\":\"操作成功\"}";
	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public void regist(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (!username.equals("") && !password.equals("")) {// 先判断是否为空
			User user = userService.isUserNameExists(username);
			if (user == null) {// 用户为空就可以进行注册了
				User registUser = new User();
				registUser.setUser_username(username);// 用户名
				registUser.setUser_password(password);// 密码
				registUser.setUser_createtime(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date()));// 注册时间
				registUser.setUser_id(Integer.parseInt((System
						.currentTimeMillis() + "").substring(5)));// id
				userService.insertUser(registUser);
				sendResponse(rep,
						JSONUtil.convertBeanToStandardJSON(registUser));
			} else {
				sendResponse(rep, ERROR_USERNAME_IS_EXIST_RESPONSE);
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
	public void login(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (!username.equals("") && !password.equals("")) {// 先判断是否为空
			User user = userService.isUserNameExists(username);
			if (user != null) {// 用户存在
				if (user.getUser_password().equals(password)) {// 验证密码
					sendResponse(rep, JSONUtil.convertBeanToStandardJSON(user));
				} else {// 密码不正确
					sendResponse(rep, ERROR_USERNAME_MATCH_PASSWORD_RESPONSE);
				}
			} else {// 用户不存在
				sendResponse(rep, ERROR_USERNAME_NOT_EXISTS_RESPONSE);
			}
		} else {
			sendResponse(rep, ERROR_RESPONSE);
		}
	}

	/**
	 * 登陆验证
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/loginOther.do", method = RequestMethod.POST)
	@ResponseBody
	public void loginOther(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
//		sendResponse(rep, "username=" + username + ",password=" + password);
		// 根目录
		System.out.println("username:"+username+",password="+password);
		String path = req.getSession().getServletContext().getRealPath("/");

		// 获得输入流
		ServletInputStream inputStream = req.getInputStream();
		// 获得数据输入流
		DataInputStream in = new DataInputStream(inputStream);
		FileOutputStream file = new FileOutputStream(path + "image/portrait_"
				+ new Date() + ".jpg");

		// 读文件
		DataOutputStream out = new DataOutputStream(file);
		byte[] buffer = new byte[4096];
		int count = 0;
		while ((count = in.read(buffer)) > 0) {
			out.write(buffer, 0, count);
		}
		out.close();
		in.close();
		file.close();
		System.out.println("success");
	}

	/**
	 * 更新个人信息
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public void updateUserInfo(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		String userName = req.getParameter("username");
		int userSex = Integer.parseInt(req.getParameter("sex"));
		String userProfiles = req.getParameter("profiles");
		userService.updateUserInfo(userName, userSex, userProfiles);
		sendResponse(rep, SUCCESS__RESPONSE);
	}

	/**
	 * 上传头像 客户端传递格式 String BOUNDARY= UUID.randomUUID().toString();//边界标识 String
	 * PREFIX="--";//分隔符 String LINE_END="\r\n"; //换行符，用于服务器readLine标识
	 * StringBuffer sb = new StringBuffer(); sb.append(PREFIX);
	 * sb.append(BOUNDARY); sb.append(LINE_END);
	 * sb.append("Content-Disposition: form-data; name=\"img\"; filename=\"" +
	 * mFile.getName() + "\"" + LINE_END);
	 * sb.append("Content-Type: application/octet-stream; charset=" + CHARSET +
	 * LINE_END); sb.append("userid"+LINE_END);
	 * dos.write(sb.toString().getBytes()); sb.setLength(0);
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadPortrait", method = RequestMethod.POST)
	@ResponseBody
	public void uploadPortrait(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 根目录
		String path = request.getSession().getServletContext().getRealPath("/");
		// 获得输入流
		ServletInputStream inputStream = request.getInputStream();
		// 获得数据输入流
		DataInputStream in = new DataInputStream(inputStream);
		// 读取客户端传递过来的文字
		System.out.println(in.readLine());// 分隔符
		System.out.println(in.readLine());// content-disposition
		System.out.println(in.readLine());// content-type
		String userName = in.readLine(); // 读取用户名
		FileOutputStream file = new FileOutputStream(path + "image/portrait_"
				+ userName + ".jpg");
		// 读文件
		DataOutputStream out = new DataOutputStream(file);
		byte[] buffer = new byte[4096];
		int count = 0;
		while ((count = in.read(buffer)) > 0) {
			out.write(buffer, 0, count);
		}
		// 写返回码
		PrintWriter writer = response.getWriter();
		writer.println(SUCCESS__RESPONSE);
		writer.flush();
		writer.close();
		out.close();
		in.close();
		file.close();
	}

	/**
	 * 下载头像
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadPortrait", method = RequestMethod.GET)
	@ResponseBody
	public void downloadPortrait(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		// 图片传输
		rep.setContentType("image/jpeg");
		String userName = req.getParameter("username");
		File file = new File(req.getSession().getServletContext()
				.getRealPath("/")
				+ "image/portrait_" + userName + ".jpg");
		FileInputStream is = new FileInputStream(file);
		ServletOutputStream out = rep.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		// 写返回码
		PrintWriter writer = rep.getWriter();
		writer.println(SUCCESS__RESPONSE);
		writer.flush();
		writer.close();
		// 图片传输
		out.flush();
		out.close();
	}

	/**
	 * 发送字符串数据
	 * 
	 * @param rep
	 * @param responseMessage
	 * @throws IOException
	 */
	private void sendResponse(HttpServletResponse rep, String responseMessage)
			throws IOException {
		rep.setContentType(CONTENT_TYPE);
		PrintWriter writer = rep.getWriter();
		writer.println(responseMessage);
		writer.flush();
		writer.close();
	}
}
