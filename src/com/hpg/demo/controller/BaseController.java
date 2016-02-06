package com.hpg.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.hpg.demo.bean.RealData;
import com.hpg.demo.bean.ResultList;
import com.hpg.demo.bean.ResultObject;

public class BaseController {
	protected static Gson mGson = new Gson();
	/**
	 * 返回类型
	 */
	protected static final String CONTENT_TYPE = "text/plain;charset=utf-8";
	
	
	/**
	 * 仅仅返回成功状态  0失败，1成功
	 * @return
	 */
	protected String getSuccessMessage() {
		ResultObject data = new ResultObject();
		data.setStatus(1);
		data.setMessage("请求成功");
		data.setData(1);
		String result = mGson.toJson(data);
		return result;
	}
	protected String getSuccessMessage(Object object) {
		ResultObject data = new ResultObject();
		data.setStatus(1);
		data.setMessage("请求成功");
		data.setData(object);
		String result = mGson.toJson(data);
		return result;
	}

	protected String getSuccessMessage(String message, Object object) {
		ResultObject data = new ResultObject();
		data.setStatus(1);
		data.setMessage(message);
		data.setData(object);
		String result = mGson.toJson(data);
		return result;
	}
	protected String getSuccessMessage(List<?> object) {
		ResultList data = new ResultList();
		RealData realData = new RealData();
		realData.setList(object);
		data.setStatus(1);
		data.setMessage("请求成功");
		data.setData(realData);
		String result = mGson.toJson(data);
		return result;
	}

	protected String getSuccessMessage(String message, List<?> object) {
		ResultList data = new ResultList();
		RealData realData = new RealData();
		realData.setList(object);
		data.setStatus(1);
		data.setMessage(message);
		data.setData(realData);
		String result = mGson.toJson(data);
		return result;
	}
	
	 /**
	  * 仅仅返回成功状态  0失败，1成功
	  * @return
	  */
	protected String getFailedMessage() {
		ResultObject data = new ResultObject();
		data.setStatus(1);
		data.setMessage("请求失败");
		data.setData(0);
		String result = mGson.toJson(data);
		return result;
	}

	protected String getFailedMessage(String message) {
		ResultObject data = new ResultObject();
		data.setStatus(1);
		data.setMessage(message);
		data.setData(0);
		String result = mGson.toJson(data);
		return result;
	}



	protected String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
