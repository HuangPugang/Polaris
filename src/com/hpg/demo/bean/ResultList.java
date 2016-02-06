package com.hpg.demo.bean;


import com.google.gson.annotations.SerializedName;

public class ResultList {
	
	@SerializedName("status")
	private int status;//状态 1表示成功  0表示失败
	@SerializedName("message")
	private String message;
	@SerializedName("data")
	private RealData data;
	
	
	public ResultList() {
	}
	public ResultList(int status, String message, RealData data) {
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
	public void setData(RealData data) {
		this.data = data;
	}
	

}
