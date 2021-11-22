/*
package com.example.demo3.dao.controller;

import com.example.demo3.dao.bean.IP;
import com.example.demo3.dao.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class IP_saveController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path="/hc/ip_query1",method = RequestMethod.POST)
    public @ResponseBody
    List<IP> Ip_query() {
        List<IP> ip_list = new ArrayList<>();
        IP_query ip_query = new IP_query();
        Map<String,String> result= ip_query.getData("159.226.242.44");
        //List<Map<String, String>> map2_list = new ArrayList<>();
        IP ip = new IP();
        ip.setIp("1");
        ip.setUrl("2");
        ip_list.add(ip);
        IP ip1 = new IP();
        ip1.setIp("3");
        ip1.setUrl("4");
        ip_list.add(ip1);
        return ip_list;
    }

}
*/
