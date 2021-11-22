package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.Rela_Case_info;
import com.example.demo3.dao.bean.Sim_Case_info;
import com.example.demo3.dao.mapper.Rela_Case_infoRepository;
import com.example.demo3.dao.mapper.Sim_Case_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class Sim_Case_infoController {
    @Autowired
    private Sim_Case_infoRepository sim_case_infoRepository;


    @RequestMapping(path="/similarity",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> Sim_info_query(@RequestBody Map<String, String> loginMap){

        Map<String,Object> map = new HashMap<>(10);

        String name1 = null;
        String similarity = null;
        String caseid1 = null;
        System.out.print(caseid1);
        if(loginMap.get("caseid1")!="")
            caseid1 = loginMap.get("caseid1");
        if(loginMap.get("name1")!="")
            name1 = loginMap.get("name1");
        if(loginMap.get("similarity")!="")
            similarity = loginMap.get("similarity");
        System.out.print(caseid1);
        System.out.print(name1);
        System.out.print(similarity);
        List <Sim_Case_info> sim_case_info_list = sim_case_infoRepository.getSimiCasequery(caseid1,name1,similarity);
        int total = sim_case_info_list.size();
        int size = Integer.parseInt(loginMap.get("size"));
        int current = Integer.parseInt(loginMap.get("nowPage"));;
        if(((current-1)*size+size) < total)
            map.put("arr",sim_case_info_list.subList((current-1)*size,((current-1)*size)+size));
        else
            map.put("arr",sim_case_info_list.subList((current-1)*size,total));
        map.put("total",total);
        map.put("nowPage", current);
        System.out.print((total/size));
        if((total%size) == 0)
            map.put("pages",(total/size));
        else
            map.put("pages",(total/size)+1);


//        String password = loginMap.get("user_password");
        //添加md5格式

//        System.out.println(MD5Utils.code(loginMap.get("user_password")));


//        System.out.println(MD5Utils.code(loginMap.get("user_password")));

        return map;
    }



}
