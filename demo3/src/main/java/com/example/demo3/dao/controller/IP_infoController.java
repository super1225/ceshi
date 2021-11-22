package com.example.demo3.dao.controller;
import com.example.demo3.dao.bean.IP;
import com.example.demo3.dao.mapper.IpRepository;
import com.example.demo3.dao.mapper.UserRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class IP_infoController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IpRepository ipRepository;


    @RequestMapping(path="/hc/ip_query",method = RequestMethod.POST)
    public @ResponseBody
    List<IP> Ip_query() {
        List<IP> ip_list = ipRepository.getIP();
        for(int i=ip_list.size()-1;i>0;i--)
        {
            if(ip_list.get(i).getIp().length() == 0)
                ip_list.remove(i);
            //ip_list.
            else
                System.out.println(ip_list.get(i).getIp());


        }
        System.out.println(ip_list);

        return ip_list;
    }

    @RequestMapping(path="/get_ip",method = RequestMethod.POST)
    public @ResponseBody
    List<IP> get_Ip() {
        List<IP> ip_list = ipRepository.getIP();
        for(int i=ip_list.size()-1;i>0;i--)
        {
            if(ip_list.get(i).getIp().length() == 0)
                ip_list.remove(i);
                //ip_list.
            else
                System.out.println(ip_list.get(i).getIp());


        }
        System.out.println(ip_list);

        return ip_list;
    }

}
