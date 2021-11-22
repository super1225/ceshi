package com.example.demo3.dao.controller;



import com.example.demo3.dao.mapper.KsUserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class ksUserController {
    @Autowired
    private KsUserRepository ksUserRepository;



}
