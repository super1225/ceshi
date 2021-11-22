package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.*;
import com.example.demo3.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class Case_mapController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private Rela_Case_infoRepository rela_case_infoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private Blog_accountRepository blog_accountRepository;

    @RequestMapping(path="/case_map",method = RequestMethod.POST)
    public @ResponseBody
    Map Case_map(@RequestBody Map<String, String> caseMap){
        List<Node> nodeList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();
        if(caseMap.get("type") == "")
        {

            List<Integer> ids = new ArrayList<>();
            if(caseMap.get("userid") == "")
            {

                ids = rela_case_infoRepository.getrelainfo(1);
                ids.add(1);
            }

            else
            {
                List<Integer> caseids = caseRepository.getcaseinfobyuserid(caseMap.get("userid"));
                ids.addAll(caseids);
                for(int k=0;k<caseids.size();k++)
                {
                    ids.addAll(rela_case_infoRepository.getrelainfo(caseids.get(k)));
                }
                System.out.print("这里111111："+ids);

            }
            //ids.add(caseMap.get("id"));
            Integer idnum = 0;

            for(int i=0; i<ids.size();i++)
            {
                Case case1 = caseRepository.getCaseById(ids.get(i));
                Node node1 = new Node();
                node1.setId(idnum++);
                node1.setName(case1.getName());
                node1.setType("0");
                node1.setUrl("0.jpg");
                nodeList.add(node1);


                Node node2 = new Node();
                node2.setId(idnum++);
                node2.setName(case1.getType());
                node2.setType("4");
                node2.setUrl("4.jpg");
                nodeList.add(node2);
                Edge edge1 = new Edge(node1.getId(),node2.getId(),"1");
                edgeList.add(edge1);

                Node node3 = new Node();
                node3.setId(idnum++);
                node3.setName(String.valueOf(case1.getAmount()));
                node3.setType("2");
                node3.setUrl("2.jpg");
                nodeList.add(node3);
                Edge edge2 = new Edge(node1.getId(),node3.getId(),"2");
                edgeList.add(edge2);

                Node node4 = new Node();
                node4.setId(idnum++);
                node4.setName(case1.getPlace());
                node4.setType("5");
                node4.setUrl("5.jpg");
                nodeList.add(node4);
                Edge edge3 = new Edge(node1.getId(),node4.getId(),"3");
                edgeList.add(edge3);

                List<Integer> ids1 = new ArrayList<>();
                System.out.print("fanhui"+case1.getPersonid_involve());
                String[] as = case1.getPersonid_involve().split(",");
                System.out.print(as);
                for(int j=0;j<as.length;j++)
                {
                    System.out.print("这里："+as[j]);
                    if(as[j] != "" && !as[j].isEmpty())
                    {
                        System.out.print("111111");
                        System.out.print("这里："+Integer.parseInt(as[j]));
                        ids1.add(Integer.parseInt(as[j]));
                    }
                }

                //ids.add(caseMap.get("id"));
                for(int k=0; k<ids1.size();k++) {
                    Node node = new Node();
                    node.setId(idnum++);
                    node.setName((userRepository.getUserById(ids1.get(k)).getName()));
                    node.setUserid(ids1.get(k));
                    node.setType("1");
                    nodeList.add(node);
                    Edge edge4 = new Edge(node1.getId(),node.getId(),"4");
                    edgeList.add(edge4);
                }
                List<Integer> ids2 = new ArrayList<>();
                String[] as1 = case1.getVictims().split(",");
                for(int j=0;j<as1.length;j++)
                {
                    if(as1[j] != "" && !as1[j].isEmpty())
                    {

                        System.out.print("这里："+Integer.parseInt(as1[j]));
                        ids2.add(Integer.parseInt(as1[j]));
                    }

                }

                //ids.add(caseMap.get("id"));
                for(int k=0; k<ids2.size();k++) {
                    Node node = new Node();
                    node.setId(idnum++);
                    node.setName((userRepository.getUserById(ids2.get(k)).getName()));
                    node.setUserid(ids2.get(k));
                    node.setType("3");
                    nodeList.add(node);
                    Edge edge4 = new Edge(node1.getId(),node.getId(),"4");
                    edgeList.add(edge4);
                }

            }

        }
        else if(Integer.parseInt(caseMap.get("type")) == 2)
        {
            List<Hotel> hotel_list = new ArrayList<>();
            if(caseMap.get("userid").toString() == "")
                hotel_list = hotelRepository.getHotelByUserId(1);
            else
                hotel_list = hotelRepository.getHotelByUserId(Integer.parseInt(caseMap.get("userid")));
            Integer idnum = 0;
            System.out.print("leibiachangdu:"+hotel_list.size());
            for(int j=0;j<hotel_list.size();j++)
            {
                List<Integer> ids = new ArrayList<>();
                Node node1 = new Node();
                node1.setId(idnum++);
                node1.setName(hotel_list.get(j).getHotelname());
                node1.setType("1");
                nodeList.add(node1);

                Node node2 = new Node();
                node2.setId(idnum++);
                node2.setName((userRepository.getUserById(hotel_list.get(j).getUserid())).getName());
                node2.setType("0");
                node2.setUserid(hotel_list.get(j).getUserid());
                nodeList.add(node2);
                Edge edge1 = new Edge(node1.getId(),node2.getId(),"1");
                edgeList.add(edge1);
                String[] as = hotel_list.get(j).getPartnerids().split(",");
                for(int i=0;i<as.length;i++)
                {
                    System.out.print("这里："+Integer.parseInt(as[i]));
                    ids.add(Integer.parseInt(as[i]));
                }

                //ids.add(caseMap.get("id"));
                for(int i=0; i<ids.size();i++)
                {
                    Node node = new Node();
                    node.setId(idnum++);
                    node.setName((userRepository.getUserById(ids.get(i)).getName()));
                    node.setUserid(ids.get(i));
                    node.setType("2");
                    nodeList.add(node);

                    Edge edge2 = new Edge(node1.getId(),node.getId(),"2");
                    edgeList.add(edge2);

                }
            }
        }
        else if(Integer.parseInt(caseMap.get("type")) == 1)
        {
            List<Travel> travel_list = new ArrayList<>();
            if(caseMap.get("userid").toString() == "")
                travel_list = travelRepository.getTravelByUserId(1);
            else
                travel_list = travelRepository.getTravelByUserId(Integer.parseInt(caseMap.get("userid")));
            Integer idnum = 0;
            System.out.print("leibiachangdu:"+travel_list.size());
            for(int j=0;j<travel_list.size();j++)
            {
                List<Integer> ids = new ArrayList<>();
                Node node1 = new Node();
                node1.setId(idnum++);
                node1.setName(travel_list.get(j).getTrainnumber());
                node1.setType("1");
                nodeList.add(node1);

                Node node2 = new Node();
                node2.setId(idnum++);
                node2.setName((userRepository.getUserById(travel_list.get(j).getUserid())).getName());
                node2.setType("0");
                nodeList.add(node2);
                Edge edge1 = new Edge(node1.getId(),node2.getId(),"1");
                edgeList.add(edge1);
                String[] as = travel_list.get(j).getPartnerids().split(",");
                for(int i=0;i<as.length;i++)
                {
                    System.out.print("这里："+Integer.parseInt(as[i]));
                    ids.add(Integer.parseInt(as[i]));
                }

                //ids.add(caseMap.get("id"));
                for(int i=0; i<ids.size();i++)
                {
                    Node node = new Node();
                    node.setId(idnum++);
                    node.setName((userRepository.getUserById(ids.get(i)).getName()));
                    node.setUserid(ids.get(i));
                    node.setType("2");
                    nodeList.add(node);

                    Edge edge2 = new Edge(node1.getId(),node.getId(),"2");
                    edgeList.add(edge2);

                }
            }
        }
        else if(Integer.parseInt(caseMap.get("type")) == 3)
        {
            int idnum = 0;
            List<Blog> blog_list = new ArrayList<>();
            if(caseMap.get("userid").toString() == "")
                blog_list = blogRepository.getBlogByuserId(1);
            else
                blog_list = blogRepository.getBlogByuserId(Integer.parseInt(caseMap.get("userid")));
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

        }
        System.out.println(nodeList.size());
        for(int j=0; j<nodeList.size();j++)
        {
            System.out.println( nodeList.get(j).getName());
            for(int k=j+1; k<nodeList.size();k++)
            {
                System.out.println( nodeList.get(k).getName());
                if(nodeList.get(k).getName().equals(nodeList.get(j).getName()))
                {
                    System.out.println("caozuo");
                    for(int m=0; m<edgeList.size(); m++)
                    {
                        if(edgeList.get(m).getId1() == nodeList.get(k).getId())
                        {
                            edgeList.get(m).setId1(nodeList.get(j).getId());
                        }
                        else if(edgeList.get(m).getId2() == nodeList.get(k).getId())
                        {
                            edgeList.get(m).setId2(nodeList.get(j).getId());
                        }

                    }
                    System.out.println(nodeList.size());
                    nodeList.remove(k);
                }

            }
        }

//        Case case1 = new Case();
//        case1 = caseRepository.getCaseById(loginMap.get("id"));
        Map<String, Object> map = new HashMap<>(10);
        map.put("nodes",nodeList);
        map.put("edge",edgeList);

        System.out.println("zuihoushudhu");
        System.out.println(nodeList);
        System.out.println(edgeList);
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
