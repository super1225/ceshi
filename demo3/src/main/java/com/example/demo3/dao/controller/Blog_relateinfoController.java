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
public class Blog_relateinfoController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private Blog_accountRepository blog_accountRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/blog_relateinfo",method = RequestMethod.POST)
    public @ResponseBody
    Map Blog_relateinfo(@RequestBody Map<String, Integer> blogMap) {


        List<Node> nodeList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();
        List<Blog> blog_list = blogRepository.getBlogByuserId(1);
        Integer idnum = 0;
        for (int j = 0; j < blog_list.size(); j++) {
            Blog blog = blogRepository.getBlogById(blog_list.get(j).getId());
            String[] as = blog.getForward_accounts().split(",");
            String[] as1 = blog.getLike_accounts().split(",");
            Node node1 = new Node();
            node1.setId(idnum++);
            node1.setName(blog.getBlog());
            node1.setType("1");
            nodeList.add(node1);

            Node node2 = new Node();
            node2.setId(idnum++);
            node2.setName(blog_accountRepository.getBlogAccountById(blog.getUserid()).getAccount());
            node2.setType("0");
            nodeList.add(node2);
            Edge edge1 = new Edge(node1.getId(), node2.getId(), "1");
            edgeList.add(edge1);
            List<Integer> ids = new ArrayList<>();
            List<Integer> ids1 = new ArrayList<>();
            for (int i = 0; i < as.length; i++) {
                System.out.print("这里：" + Integer.parseInt(as[i]));
                ids.add(Integer.parseInt(as[i]));
            }
            for (int i = 0; i < as1.length; i++) {
                System.out.print("这里：" + Integer.parseInt(as[i]));
                ids1.add(Integer.parseInt(as1[i]));
            }

            //ids.add(caseMap.get("id"));
            for (int i = 0; i < ids.size(); i++) {
                Node node = new Node();
                node.setId(idnum++);
                node.setName(blog_accountRepository.getBlogAccountById(ids.get(i)).getAccount());
                node.setType("2");
                nodeList.add(node);

                Edge edge2 = new Edge(node1.getId(), node.getId(), "2");
                edgeList.add(edge2);

            }
            for (int i = 0; i < ids1.size(); i++) {
                Node node = new Node();
                node.setId(idnum++);
                node.setName(blog_accountRepository.getBlogAccountById(ids1.get(i)).getAccount());
                node.setType("3");
                nodeList.add(node);

                Edge edge2 = new Edge(node1.getId(), node.getId(), "2");
                edgeList.add(edge2);

            }
        }


        //        Case case1 = new Case();
        //        case1 = caseRepository.getCaseById(loginMap.get("id"));
        Map<String, Object> map = new HashMap<>(10);
        map.put("nodes", nodeList);
        map.put("edge", edgeList);

        return map;


        //        System.out.println(MD5Utils.code(loginMap.get("user_password")));


        //
        //    List<> case2map(Case case_info)
        //    {
        //
        //
        //
    }

}
