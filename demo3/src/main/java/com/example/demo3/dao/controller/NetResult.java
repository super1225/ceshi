package com.example.demo3.dao.controller;

public class NetResult {

	private int statusCode;//响应状态码
	private String responseContent;//响应内容

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}



}
