package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.Statics_info;
import com.example.demo3.dao.bean.User;
import com.example.demo3.dao.mapper.Statics_infoRepository;
import com.example.demo3.dao.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class Statics_infoController {

    @Autowired
    private Statics_infoRepository Statics_infoRepository;

    @RequestMapping(path="/info_statics",method = RequestMethod.POST)
    public @ResponseBody
    Map Info_statics(@RequestBody(required=false) Map<String, Integer> info_scanmap){

        Statics_info statics_info = Statics_infoRepository.getinfo();
        Map<String, Object> map = new HashMap<>(10);
        map.put("HC案例总数",statics_info.getCase_amount());
        map.put("国内案件总数",statics_info.getCase_amount_inner());
        map.put("跨国案件总数",statics_info.getCase_amount_cross());
        map.put("涉案总人数",statics_info.getNum_of_peo());
        map.put("受害总人数",statics_info.getNum_of_victims());
        map.put("受害总金额",statics_info.getMoney());
        map.put("最大涉案金额",statics_info.getMoney());
        return map;
    }
    @RequestMapping(path="/info_scan",method = RequestMethod.POST)
    public @ResponseBody
    Map Info_scan(@RequestBody Map<String, Integer> info_scanmap){

        Statics_info statics_info = Statics_infoRepository.getinfo();
        Map<String, Object> map = new HashMap<>(10);
        map.put("ip",statics_info.getIp_num());
        map.put("手机号",statics_info.getPhone_num());
        map.put("微博号",statics_info.getBlog_num());
        map.put("QQ号",statics_info.getQq_num());
        map.put("微信号码",statics_info.getWechat_num());
        return map;
    }
    @RequestMapping(path="/hc_info_scan",method = RequestMethod.POST)
    public @ResponseBody
    Map Hc_info_scan(@RequestBody Map<String, Integer> hc_info_scanmap){

        Statics_info statics_info  = Statics_infoRepository.getinfo();
        Map<String, Object> map = new HashMap<>(10);
        map.put("金融钓鱼",statics_info.getFina_phishing_num());
        map.put("网络攻击",statics_info.getNet_att_num());
        map.put("Sim卡",statics_info.getSim_num());
        return map;
    }



}
