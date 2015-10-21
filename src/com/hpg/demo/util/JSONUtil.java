package com.hpg.demo.util;

import java.util.List;

import com.hpg.demo.bean.Comment;
import com.hpg.demo.bean.Posts;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JSONUtil {
	/**
	 * 请求失败时的返回码
	 */
	public static final String ERROR_RESPONSE= "{\"rc\":0,\"me\":\"请求失败\"}";
	public static final String SUCCESS_RESPONSE_HEAD="{\"rc\":1,\"me\":\"请求成功\",\"count\":";
	//避免产生对象
	private JSONUtil(){}
	
	/**
	 * 对象list转json
	 * @param users
	 * @return
	 */
	public static String beanListToJSON(List<?> object){
		JSONArray array = JSONArray.fromObject(object);
		String jsonstr = array.toString();
		return jsonstr;
	}
	
	/**
	 * 对象转json
	 * @param user
	 * @return
	 */
	public static String beanToJSON(Object o){
		JSONObject object = JSONObject.fromObject(o);
		return object.toString();
	}
	
	/**
	 * 把list转成标准的json字符串
	 * @param list 
	 * @param rc 结果码
	 * @return
	 */
	public static String convertListToStandardJSON(List<?> list){
		try {
			return SUCCESS_RESPONSE_HEAD+list.size()+","
			
			+"\"re\":"+
			
			JSONUtil.beanListToJSON(list)+"}";
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR_RESPONSE;
		}
	}
	
	/**
	 * 把对象转成标准json字符串
	 * @param object 需要转换的对象
	 * @param rc 返回码
	 * @return
	 */
	public static String convertBeanToStandardJSON(Object object){

			return "{\"rc\":1,\"me\":\"请求成功\",\"re\":"+
			JSONUtil.beanToJSON(object)+"}";

	}
	
}
