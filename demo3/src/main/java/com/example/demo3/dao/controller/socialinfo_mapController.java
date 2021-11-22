package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.*;
import com.example.demo3.dao.mapper.BlogRepository;
import com.example.demo3.dao.mapper.Blog_accountRepository;
import com.example.demo3.dao.mapper.CaseRepository;
import com.example.demo3.dao.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class socialinfo_mapController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private Blog_accountRepository blog_accountRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/socailinfo",method = RequestMethod.POST)
    public @ResponseBody
    Map Blog_map(@RequestBody Map<String,String> caseMap){
        Map<String, Object> map = new HashMap<>(10);
        int idnum = 0;
        List<Node> nodeList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();
        Blog_account blog_account = new Blog_account();
        caseMap.put("username","yang1");
        caseMap.put("account","");
        if(!caseMap.get("username").equals(""))
            blog_account  = blog_accountRepository.getBlogAccountByusername(caseMap.get("username"));
        else if((!caseMap.get("account").equals("")))
            blog_account  = blog_accountRepository.getBlogAccountByaccount(caseMap.get("account"));

        if(blog_account == null)
            return map;
        List<Blog> blog_list = blogRepository.getBlogByuserId(blog_account.getId());

        map.put("person_info",blog_account);
        map.put("blog",blog_list);

        return map;


    //        System.out.println(MD5Utils.code(loginMap.get("user_password")));

            //return case1;
        }
    //
    //    List<> case2map(Case case_info)
    //    {
    //
    //
    //
    //    }


        Case Case_info(int id)
        {
            Case case1 = new Case();
            case1 = caseRepository.getCaseById(id);
            return case1;


        }

}
