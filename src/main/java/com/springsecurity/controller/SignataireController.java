package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signataire")
public class SignataireController {
    @GetMapping("index")
    public String index(){
        return "signataire/index";
    }

    @GetMapping("hachage")
    public String hachage(){
        return "signataire/hachage";
    }
}
