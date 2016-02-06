package com.hpg.demo.bean;

import com.google.gson.annotations.SerializedName;

public class ResultObject {
	
	@SerializedName("status")
	private int status;//状态 1表示成功  0表示失败
	@SerializedName("message")
	private String message;
	@SerializedName("data")
	private Object data;
	
	
	public ResultObject() {
	}
	public ResultObject(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
