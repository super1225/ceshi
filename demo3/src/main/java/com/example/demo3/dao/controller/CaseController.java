package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.Hcrecent;
import com.example.demo3.dao.bean.User;
import com.example.demo3.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;

@Controller
@CrossOrigin
public class CaseController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(path="/case1",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> Case_query(@RequestBody Map<String, String> loginMap){
        Map<String,Object> map = new HashMap<>(10);
 /*       if(loginMap.get("name")!="")
            List<Case> caseList= caseRepository.getinfo();
        else if()*/
        List<Case> caseList= caseRepository.getinfo();
        int total = caseList.size();
        int size = Integer.parseInt(loginMap.get("size"));
        int current = Integer.parseInt(loginMap.get("nowPage"));;
        if(((current-1)*size+size) < total)
            map.put("arr",caseList.subList((current-1)*size,((current-1)*size)+size));
        else
            map.put("arr",caseList.subList((current-1)*size,total));
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

        return map;
    }


    @RequestMapping(path="/case",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> Case_query1(@RequestBody Map<String, String> loginMap){
        Map<String,Object> map = new HashMap<>(10);
 /*       if(loginMap.get("name")!="")
            List<Case> caseList= caseRepository.getinfo();
        else if()*/
        String phone = null;
        String bankard = null;
        String website = null;
        String personname_involve = null;
        String victimsname = null;
        if(loginMap.get("bankcard")!="")
            bankard = loginMap.get("bankcard");
        if(loginMap.get("personname_involve")!="")
            personname_involve = loginMap.get("personname_involve");
        if(loginMap.get("victimsname")!="")
            victimsname = loginMap.get("victimsname");
        if(loginMap.get("phone")!="")
            phone = loginMap.get("phone");
        if(loginMap.get("website")!="")
            website = loginMap.get("website");
        List<Case> caseList= caseRepository.getCasequery(phone,bankard,website,personname_involve,victimsname);
        int total = caseList.size();
        int size = Integer.parseInt(loginMap.get("size"));
        int current = Integer.parseInt(loginMap.get("nowPage"));;
        if(((current-1)*size+size) < total)
            map.put("arr",caseList.subList((current-1)*size,((current-1)*size)+size));
        else
            map.put("arr",caseList.subList((current-1)*size,total));
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
        map.put("total",caseList);


//        System.out.println(MD5Utils.code(loginMap.get("user_password")));

        return map;
    }

    @RequestMapping(path="/case_detail",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> case_detail(@RequestBody Map<String, Integer> loginMap){
        Map<String,Object> map = new HashMap<>(10);
 /*       if(loginMap.get("name")!="")
            List<Case> caseList= caseRepository.getinfo();
        else if()*/
        Case case1 = caseRepository.getCaseById(loginMap.get("id"));
        List<User> userList= new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        String[] as = case1.getVictims().split(",");
        for (int i = 0; i < as.length; i++) {
            System.out.print("这里：" + Integer.parseInt(as[i]));
            //ids.add(Integer.parseInt(as[i]));
            userList.add(userRepository.getUserById(Integer.parseInt(as[i])));
        }
        map.put("base",case1);
        map.put("arr",userList);
        map.put("idcard",userRepository.getUserById(Integer.parseInt(case1.getPersonid_involve())).getIdcard());
        return map;
    }

    @RequestMapping(path="/recent_case_info",method = RequestMethod.POST)
    public @ResponseBody
    List<Hcrecent> recent_case_info(@RequestBody Map<String, Integer> loginMap){

        List<Hcrecent> hcrecentList= new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM");
        Date now = new Date();
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(now);//把当前时间赋给日历
        for(int i=0; i<5;i++)
        {
            System.out.println(i);
            System.out.println(calendar.MONTH);
            calendar.add(calendar.MONTH, -1); //设置为前3月
            dBefore = calendar.getTime(); //得到前3月的时间
            String defaultStartDate = sdf.format(dBefore)+"-1";
            String defaultEndDate = sdf.format(dBefore)+"-30";
            //System.out.print("shijian1：" + defaultEndDate+);
            //System.out.print("shijian2：" +defaultStartDate);
            int num = caseRepository.getrecentCaseBytime(defaultStartDate,defaultEndDate,"金融钓鱼");
            Hcrecent hcrecent = new Hcrecent(defaultStartDate,"金融钓鱼",Integer.toString(num));
            hcrecentList.add(hcrecent);
            int num1 = caseRepository.getrecentCaseBytime(defaultStartDate,defaultEndDate,"网络攻击");
            Hcrecent hcrecent1 = new Hcrecent(defaultStartDate,"网络攻击",Integer.toString(num1));
            hcrecentList.add(hcrecent1);
            int num2 = caseRepository.getrecentCaseBytime(defaultStartDate,defaultEndDate,"sim卡诈骗");
            Hcrecent hcrecent2 = new Hcrecent(defaultStartDate,"sim卡诈骗",Integer.toString(num2));
            hcrecentList.add(hcrecent2);
        }

        return hcrecentList;
    }
    @RequestMapping(path="/recent_case_import",method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> recent_casrecent_case_import(@RequestBody Map<String, Integer> loginMap){

        List<Integer> hcrecentList= new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM");
        Date now = new Date();
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(now);//把当前时间赋给日历
        for(int i=0; i<6;i++)
        {
            System.out.println(i);
            System.out.println(calendar.MONTH);
            calendar.add(calendar.MONTH, -1); //设置为前3月
            dBefore = calendar.getTime(); //得到前3月的时间
            String defaultStartDate = "20"+sdf.format(dBefore)+"-1";
            String defaultEndDate = "20"+sdf.format(dBefore)+"-30";
            System.out.print("shijian1：" + defaultEndDate);
            System.out.print("shijian2：" +defaultStartDate);
            int num = caseRepository.getrecentimportinfoBytime(defaultStartDate,defaultEndDate);
            hcrecentList.add(num);
        }

        return hcrecentList;
    }
    @RequestMapping(path="/mainplace_case_info",method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> mainplace_case_info(@RequestBody Map<String, Integer> loginMap){

        List<Integer> hcList= new ArrayList<>();
        hcList.add(caseRepository.getCaseByplace("北京"));
        hcList.add(caseRepository.getCaseByplace("上海"));
        hcList.add(caseRepository.getCaseByplace("广州"));
        hcList.add(caseRepository.getCaseByplace("深圳"));
        hcList.add(caseRepository.getCaseByplace("河南"));
        return hcList;
    }



}
