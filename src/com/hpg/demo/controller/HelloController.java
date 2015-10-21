package com.hpg.demo.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpg.demo.dao.UserMapper;

//朋友一定很好奇这个是干什么的，这个呢就是告诉spring这个类是Controller
@Controller
// 是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
@RequestMapping("HelloController")
public class HelloController {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	// value： 指定请求的实际地址；
	// method： 指定请求的method类型， GET、POST、PUT、DELETE等；application/json
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET, produces = { "text/plain;charset=UTF-8" })
	// 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
	@ResponseBody
	// 那么我们要访问此方法是
	// 完整路径应该是http://ip地址:端口/SpringMVCWebService/HelloController/hello.json
	public Object hello(HttpServletRequest request, HttpServletResponse response) {
		java.lang.String nameString = request.getParameter("username");
		System.out.println(request.getParameter("name") + "输出字符串");
		return "fsfs" + nameString;

	}

	/**
	 * 第二种方式
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	@ResponseBody
	public void hello2(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		// java.lang.String username = req.getParameter("name");
		// java.lang.String password = req.getParameter("pswd");
		//
		// System.out.println(" 直接 PrintWriter输出json :" + username + "--->"
		// + password);
		//
		// PrintWriter writer = rep.getWriter();
		//
		// rep.setContentType("text/html;charset=utf-8");
		// writer.println("{\"errorCode\":\"哈哈哈哈哈\"" + "}" + username +
		// password);
		// writer.flush();
		// writer.close();
		try {
			readFile(req, rep);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		// sendImage(req,rep);

	}

	@RequestMapping(value = "/getPortrait", method = RequestMethod.GET)
	@ResponseBody
	public void sendPortrait(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		sendImage(req, rep);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void helloPost(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		// java.lang.String usernameString = req.getParameter("password");
		// System.out.println(usernameString);
		// System.out.println(req.getSession().getServletContext().getRealPath("/"));
		// System.out.println(getClass().getResource("/").getPath());
		// PrintWriter writer = rep.getWriter();
		// rep.setContentType("text/html;charset=utf-8");
		// writer.println("{\"errorCode\":\"哈哈哈哈哈\"" + "}");
		// writer.flush();
		// writer.close();

		try {
			readFile(req, rep);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 图片传输
	private void sendImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 图片传输
		response.setContentType("image/jpeg");
		String userid = request.getParameter("userid");
		System.out.println(request.getSession().getServletContext()
				.getRealPath("/"));
		File file = new File(request.getSession().getServletContext()
				.getRealPath("/")
				+ "image/portrait_" + userid + ".jpg");
		FileInputStream is = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		// 图片传输
		out.flush();
		out.close();
	}

	// 音乐下载
	private void downLoadAudio(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		File file = new File("/images/fuqin.mp3");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + file.getName());
		// 创建文件输入流
		FileInputStream is = new FileInputStream(file);
		// 响应输出流
		ServletOutputStream out = response.getOutputStream();
		// 创建缓冲区
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		is.close();
		out.flush();
		out.close();
	}

	/**
	 * 读取文件（图片，音频）
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void readFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post Request!!!");
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
		String userid = in.readLine(); // 读取用户id
		FileOutputStream file = new FileOutputStream(path + "image/portrait_"
				+ userid + ".jpg");

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

}
