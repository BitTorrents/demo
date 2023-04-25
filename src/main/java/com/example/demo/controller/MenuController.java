package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping(value = "/menu/new")
    public String menuForm(){
        return "/menu/menuForm";
    }
}
