package com.example.demo3.dao.controller;

import java.net.URLEncoder;

public class UrlData {

	private StringBuffer url = new StringBuffer();


	public UrlData(String url) {
		super();
		this.url.append(url);
	}

	public String getUrl(){
		return url.toString();
	}

	public void addParam(String key,String value){
		try {
			String valueEncode = URLEncoder.encode(value, "utf-8");
			if(isNotBlank(url.toString())){
				if(url.toString().contains("?")){
					url.append("&").append(key).append("=").append(valueEncode);
				}else{
					url.append("?").append(key).append("=").append(valueEncode);
				}
			}else{
				System.out.println("url未初始化");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isNotBlank(String str){
		if("".equals(str.trim()) || null == str.trim()){
			return false;
		}
		return true;
	}

}
