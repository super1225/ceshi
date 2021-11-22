package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.Case;
import com.example.demo3.dao.bean.Rela_Case_info;
import com.example.demo3.dao.bean.Rela_person_info;
import com.example.demo3.dao.bean.User;
import com.example.demo3.dao.mapper.CaseRepository;
import com.example.demo3.dao.mapper.Rela_Case_infoRepository;
import com.example.demo3.dao.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@CrossOrigin
public class Rela_Case_infoController {
    @Autowired
    private Rela_Case_infoRepository rela_case_infoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CaseRepository caseRepository;
    @RequestMapping(path="/target-map",method = RequestMethod.POST)
    public @ResponseBody
    Map target_map_query(@RequestBody Map<String, String> target_map){
        //User user = userRepository.getUserByName(target_map.get("name"));
        List<Rela_person_info> rela_person_info_list= new ArrayList<>();
        List<Rela_Case_info> rela_case_info_list = rela_case_infoRepository.getnamerelainfo("刘平");
        for(int i=0; i<rela_case_info_list.size();i++)
        {
            Rela_person_info rela_person_info = new Rela_person_info();
            rela_person_info.set关联人物(rela_case_info_list.get(i).getName2());
            rela_person_info.set关联案件id(rela_case_info_list.get(i).getCaseid2());
            rela_person_info.set关联类型(rela_case_info_list.get(i).getRelation_type());
            rela_person_info.set案件信息(caseRepository.getCaseById(rela_case_info_list.get(i).getCaseid2()));
            rela_person_info_list.add(rela_person_info);
        }
        Map<String, Object> map = new HashMap<>(10);
        map.put("person_info",rela_person_info_list);
        return map;
    }

    @RequestMapping(path="/relation",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> Relate_info_query(@RequestBody Map<String, String> loginMap){
        Map<String,Object> map = new HashMap<>(10);

        String name1 = null;
        String place1 = null;
        String caseid1 = null;
        if(loginMap.get("caseid1")!="")
            caseid1 = loginMap.get("caseid1").toString();
        if(loginMap.get("name1")!="")
            name1 = loginMap.get("name1");
        if(loginMap.get("place1")!="")
            place1 = loginMap.get("place1");
        List <Rela_Case_info> rela_case_info_list = rela_case_infoRepository.getRelaCasequery(caseid1,name1,place1);
        int total = rela_case_info_list.size();
        int size = Integer.parseInt(loginMap.get("size"));
        int current = Integer.parseInt(loginMap.get("nowPage"));;
        if(((current-1)*size+size) < total)
            map.put("arr",rela_case_info_list.subList((current-1)*size,((current-1)*size)+size));
        else
            map.put("arr",rela_case_info_list.subList((current-1)*size,total));
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
