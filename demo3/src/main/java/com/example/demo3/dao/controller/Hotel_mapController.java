package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.Edge;
import com.example.demo3.dao.bean.Hotel;
import com.example.demo3.dao.bean.Node;
import com.example.demo3.dao.bean.Travel;
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
public class Hotel_mapController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private Rela_Case_infoRepository rela_case_infoRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/hotel_map",method = RequestMethod.POST)
    public @ResponseBody
    Map Travel_map(@RequestBody Map<String, Integer> travleMap){

        List<Node> nodeList = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();
        List<Hotel> hotel_list = new ArrayList<>();
        if(travleMap.get("id").toString() == "")
            hotel_list = hotelRepository.getHotelByUserId(1);
        else
            hotel_list = hotelRepository.getHotelByUserId(travleMap.get("id"));
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
                node.setType("2");
                nodeList.add(node);

                Edge edge2 = new Edge(node1.getId(),node.getId(),"2");
                edgeList.add(edge2);

            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("nodes",nodeList);
        map.put("edge",edgeList);

        return map;
    }


}
