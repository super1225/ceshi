package com.example.demo3.dao.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.demo3.dao.mapper.CaseRepository;
import com.example.demo3.dao.mapper.IpRepository;
import com.example.demo3.dao.mapper.Statics_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class GeturldataController {
    @Autowired
    private IpRepository ipRepository;



   /* @Autowired
    HttpClient httpClient;


    @RequestMapping(value = "hellos", method = RequestMethod.GET)
    public String hello() {
        String url = "http://10.5.0.203:8080/info_scan";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        System.out.print(httpClient.client(url, method, params));
        return httpClient.client(url, method, params);

    }*/

    @RequestMapping(path="/getdata",method = RequestMethod.POST)
    public void get_domaindata(RestTemplate rest, HttpEntity<String> entity){
        String url = "http://10.42.3.70:12341/abnormaldetection/webs/list?get_anomaly_list=1";
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if(!url.equals(""))
        {
            String data = rest.exchange(url, HttpMethod.GET, entity, String.class).getBody();
            //list = JSONObject.parseObject(data, List.class);
            String data1 = data.substring(data.indexOf("[")+1,data.indexOf("]"));
            String[] data_list = data1.split(",");
            //String[] data_list = {"www.baidu.com","www.ict.ac.cn"};
            for(int i=0; i<data_list.length; i++)
            {
                data_list[i] = data_list[i].substring(data_list[i].indexOf("\"")+1, data_list[i].lastIndexOf("\""));
                System.out.println(IP_query.getData(data_list[i]));
                if(IP_query.getData(data_list[i]) == null)
                {
                    ipRepository.addIP("", data_list[i]);

                }
                else
                {
                    String ip1 = IP_query.getData(data_list[i]).get("IP");
                    ipRepository.addIP(ip1, data_list[i]);

                }


            }

        }




    }





}




