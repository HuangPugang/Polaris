package com.hpg.demo.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpg.demo.bean.Posts;
import com.hpg.demo.service.PostImageService;
import com.hpg.demo.service.PostService;
import com.hpg.demo.util.JSONUtil;


@Controller
@RequestMapping("Post")
public class PostsController extends BaseController {

	@Resource(name = "postServiceImpl")
	private PostService postService;
	@Resource(name="postImageServiceImpl")
	private PostImageService postImageService;

	/**
	 * 获得热门帖子
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getHotPostList.do", method = RequestMethod.GET)
	public void getHotPostList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter writer = response.getWriter();
		List<Posts> list = postService.getHotPostList2();
		
		writer.println(JSONUtil.convertListToStandardJSON(list));
		writer.flush();
		writer.close();
	}

	/**
	 * 根据最后一条id获得热门帖子
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getMoreHotPostListByLastId.do", method = RequestMethod.GET)
	public void getMoreHotPostListByLastId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			int lastPostId = Integer.parseInt(request
					.getParameter("lastPostId"));
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			List<Posts> list = postService
					.getMoreHotPostListByLastId(lastPostId);
			writer.println(JSONUtil.convertListToStandardJSON(list));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			writer.println(ERROR_RESPONSE);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 获得热门帖子
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getNewPostList.do", method = RequestMethod.GET)
	public void getNewPostList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println(request.getSession().getServletContext().getRealPath("/headPortrait"));
		response.setContentType(CONTENT_TYPE);
		PrintWriter writer = response.getWriter();
		List<Posts> list = postService.getNewPostList();
		writer.println(JSONUtil.convertListToStandardJSON(list));
		writer.flush();
		writer.close();
	}

	/**
	 * 根据最后一条id获得热门帖子
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getMoreNewPostListByLastId", method = RequestMethod.GET)
	public void getMoreNewPostListByLastId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try {
			int lastPostId = Integer.parseInt(request
					.getParameter("lastPostId"));
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			List<Posts> list = postService
					.getMoreNewPostListByLastId(lastPostId);
			writer.println(JSONUtil.convertListToStandardJSON(list));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			writer.println(ERROR_RESPONSE);
			writer.flush();
			writer.close();
			return;
		}
	}

	/**
	 * 根据id获得内容
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/getPostContentById", method = RequestMethod.GET)
	public void getPostContentById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			int postId = Integer.parseInt(request.getParameter("postId"));
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			Posts posts = postService.getPostContentById(postId);
			writer.println(JSONUtil.convertBeanToStandardJSON(posts));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			response.setContentType(CONTENT_TYPE);
			PrintWriter writer = response.getWriter();
			writer.println(ERROR_RESPONSE);
			writer.flush();
			writer.close();
			return;
		}
	}
	
	
	/**
	 * 上传post图片 客户端传递格式 String BOUNDARY= UUID.randomUUID().toString();//边界标识 String
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
	@RequestMapping(value = "/uploadPostImage", method = RequestMethod.POST)
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
		String postId = in.readLine();//读取文章id
		FileOutputStream file = new FileOutputStream(path + "post_image/post_image_"
				+ System.currentTimeMillis() + ".jpg");
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
	 * 下载post图片
	 * 
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadPostImage", method = RequestMethod.GET)
	@ResponseBody
	public void downloadPortrait(HttpServletRequest req,
			HttpServletResponse rep) throws IOException {
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

}
