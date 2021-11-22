package com.example.demo3.dao.controller;


import com.example.demo3.dao.bean.User;
import com.example.demo3.dao.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path="/login",method = RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody Map<String, Integer> map){

        User res = new User();
        System.out.print("jinlail");
        res = userRepository.getUserById(map.get("id"));
        return res;
    }



}
