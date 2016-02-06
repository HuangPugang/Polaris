package com.hpg.demo.bean;

import com.google.gson.annotations.SerializedName;

public class RealData{
	@SerializedName("list")
	Object list;

	public RealData() {
	}

	public RealData(Object list) {
		this.list = list;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}
	
}
