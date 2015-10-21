package com.hpg.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hpg.demo.bean.Person;
import com.hpg.demo.bean.TestBean;

@Controller
@RequestMapping("Form")
public class FormController {
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/add.do ")
	public String add(HttpServletRequest request) {
		System.out.println("add" + request.getParameter("username"));
		System.out.println("add" + request.getParameter("password"));
		// 最终防盗request中
		request.setAttribute("username1", "haha");// 返回值

		return "form";

	}

	@RequestMapping(value = "/add2.do")
	public String add2(@RequestParam(value = "name") String username) {
		System.out.println("add" + username);

		return "form";

	}

	// 表单的name值必须和bean类的属性值一致，就可以进行传递
	@RequestMapping(value = "/add3.do ")
	public String add3(TestBean testBean) {
		System.out.println("add" + testBean.toString());

		return "index";

	}

	// 使用modelandview返回值
	@RequestMapping(value = "/add4.do ")
	public ModelAndView add4() {
		ModelAndView mav = new ModelAndView("form4");
		mav.addObject("userId", 1001);
		mav.addObject("userName", "张三");

		return mav;
	}

	// 使用model返回值 用的最多
	@RequestMapping(value = "/add5.do ")
	public String add5(Model model) {
		model.addAttribute("userId", 102101);
		model.addAttribute("userName", "张三");
		return "form5";
	}

	// 使用request返回值
	@RequestMapping(value = "/add6.do ")
	public String add6(HttpServletRequest request) {
		request.setAttribute("username1", "haha");// 返回值

		return "form6";
	}

	// 使用request返回值
	@RequestMapping(value = "/add7.do ")
	public String add7(Map map) {
		map.put("userName", "黄浦港");
		map.put("userId", 12432);
		return "form5";
	}

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
	public void fileUpload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {// 此处参数与表单参数一致
		System.out.println(request.getParameter("versionName")+request.getParameter("apkSize"));
		if (!file.isEmpty()) {
			try {
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
				System.out.println(filePath);
				File destFile = new File(filePath);
				FileUtils
						.copyInputStreamToFile(file.getInputStream(), destFile);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("哈哈");
		writer.flush();
	}

	/**
	 * 多文件上传
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/mulitiFilesUpload.do", method = RequestMethod.POST)
	public String filesUpload(@RequestParam("files") MultipartFile[] files) {// 此处参数与表单参数一致
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
				// 判断文件是否为空
				if (!file.isEmpty()) {
					try {
						// 文件保存路径
						String filePath = request.getSession()
								.getServletContext().getRealPath("/")
								+ "upload/" + file.getOriginalFilename();
						// 转存文件
						File destFile = new File(filePath);
						FileUtils.copyInputStreamToFile(file.getInputStream(),
								destFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "index";
	}

	/**
	 * 文件下载
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/filesDownload.do", method = RequestMethod.POST)
	public ResponseEntity<byte[]> filesDownload() throws IOException {
		String filePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload/app-debug.apk";
		File file2 = new File(filePath);
		String fileName = new String("app-debug.apk".getBytes("UTF-8"),
				"iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file2),
				headers, HttpStatus.CREATED);

	}

	/***
	 * 多文件上传 读取上传文件中得所有文件并返回
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list() {
		String filePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			// 打印出文件名
			System.out.println(fileNames[i]);
		}
		return mav;
	}

	@RequestMapping(value = "/listAll.do")
	public String listAll(ModelMap model) {
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i < 5; i++) {
			Person person = new Person();
			person.setAge("姓名" + i);
			person.setName("name" + i);
			person.setId("id" + i);
			list.add(person);
		}
		// ModelAndView mav = new ModelAndView("list");
		// mav.addObject("personList",list);
		model.addAttribute("personList", list);
		System.out.println("haha" + list.toString());
		// map.put("personList",list );
		return "list";
	}

	@RequestMapping(value = "/login.do")
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, ModelMap model) {
		if (username.equals("huang") && password.equals("pu")) {
			request.getSession().setAttribute("sessionUsername", username);
			request.getSession().setAttribute("sessionPassword", password);
			return "day1/login_success";
		} else {
			model.addAttribute("code", "0");
			return "day3/login";
		}
	}

	/**
	 * ajax测试
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/ajaxtest.do")
	public @ResponseBody
	String login() throws IOException {
		System.out.println(request.getParameter("name"));
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("jajaj");
		map.put("msg", "失败");
		// return new
		// String("{\"rc\":0,\"me\":\"请求失败\"}".getBytes("ISO-8859-1"),"utf-8");
		String string = "请求失败";
		return "请球失败";
	}

	@RequestMapping(value = "/person.do", method = RequestMethod.GET)
	public @ResponseBody
	Person getPersonJson() {
		Person person = new Person();
		person.setAge("24");
		person.setName("黄浦");
		person.setId("222");

		return person;
	}

	// @RequestMapping(params = "method=set")
	@RequestMapping(value = "/ajaxtest3.do")
	public void jump(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String roomid= request.getParameter("roomid");
		// String room= request.getParameter("room");
		// session.setAttribute("ROOMID", roomid);
		// session.setAttribute("ROOMNAME", room);
		// System.out.println("session set:"+room+"=="+roomid);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("哈哈");
		response.getWriter().flush();
	}
	
	@RequestMapping(value = "/getJson.do")
	public void getJson(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i < 5; i++) {
			Person person = new Person();
			person.setAge("姓名" + i);
			person.setName("name" + i);
			person.setId("id" + i);
			list.add(person);
		}
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
	}
}
