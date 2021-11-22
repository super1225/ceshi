package com.example.demo3.dao.controller;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class IP_query {

    public IP_query() {
    }

    public static CloseableHttpClient httpClient = null;
    private static RequestConfig requestConfig = null;
    private static PoolingHttpClientConnectionManager cm = null;

    public static NetResult sendHttpPost(HttpPost httpPost) {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(2000);
        cm.setDefaultMaxPerRoute(2000);
        requestConfig =  RequestConfig.custom()
                .setSocketTimeout(20 * 1000)
                .setConnectTimeout(20 * 1000)
                .setConnectionRequestTimeout(20 * 1000)
                .build();

        NetResult netResult = new NetResult();
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            httpClient = HttpClients.custom().setConnectionManager(cm).build();
            httpPost.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            if (null != entity) {
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                int statusCode = response.getStatusLine().getStatusCode();
                netResult.setStatusCode(statusCode);
                netResult.setResponseContent(responseContent);
                return netResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return netResult;
    }

    public static Map<String,String> getData(String ip){
        try {
            UrlData urlData = new UrlData("https://apidatav2.chinaz.com/single/ip");
            urlData.addParam("key","292f7a025a894f1184eebee6ecc8d72c");
            urlData.addParam("ip",ip);
            System.out.println("url:"+urlData.getUrl());
            HttpPost httpPost = new HttpPost(urlData.getUrl());// 创建httpPost
            NetResult result = sendHttpPost(httpPost);
            System.out.println(result);
            if(result != null){
                if(result.getStatusCode() == HttpStatus.SC_OK && (!result.getResponseContent().contains("null")) ){
                    System.out.println("返回结果："+result.getResponseContent().contains("null"));
                    com.alibaba.fastjson.JSONObject jsonObject =  JSONObject.parseObject(result.getResponseContent());
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("IP", jsonObject.getJSONObject("Result").getString("IP"));
                    map.put("City", jsonObject.getJSONObject("Result").getString("City"));
                    map.put("Country", jsonObject.getJSONObject("Result").getString("Country"));
                    map.put("District", jsonObject.getJSONObject("Result").getString("District"));
                    map.put("Isp", jsonObject.getJSONObject("Result").getString("Isp"));
                    map.put("Province", jsonObject.getJSONObject("Result").getString("Province"));
                    return map;
                }else{

                }
            }else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
