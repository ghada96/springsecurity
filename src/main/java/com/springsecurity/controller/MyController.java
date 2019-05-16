package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class MyController {
    @GetMapping("index")
        public String index(){
            return "admin/index";
        }
        @GetMapping("ajout")
        public String ajout(){
            return "admin/ajout";
        }
}
