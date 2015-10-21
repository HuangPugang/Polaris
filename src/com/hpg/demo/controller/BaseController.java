package com.hpg.demo.controller;

public class BaseController {
	/**
	 * 请求失败时的返回码
	 */
	protected static final String ERROR_RESPONSE = "{\"rc\":0,\"me\":\"请求失败\"}";
	/**
	 * 返回类型
	 */
	protected static final String CONTENT_TYPE = "text/plain;charset=utf-8";
	protected static final String SUCCESS__RESPONSE = "{\"rc\":1,\"me\":\"操作成功\"}";
}
