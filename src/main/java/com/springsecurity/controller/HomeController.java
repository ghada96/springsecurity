package com.springsecurity.controller;

import com.springsecurity.db.UserRepository;
import com.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/")
public class HomeController {
    @Autowired
    public UserRepository userRepository;
    @GetMapping("index")
    public String index(){
        return "index";
    }

}
