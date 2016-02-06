//package com.hpg.demo;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.annotation.Resource;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import com.hpg.demo.dao.UserMapper;
//
//@Path("/android")
//public class TestWebservice {
//	@Resource(name="userMapper")
//	private UserMapper userMapper;
//	@Path("/gettext")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getJson() throws UnsupportedEncodingException{
//
//		return "{\"errorCode\":\"0\"" + "}";
//		
//	}
//
//}
