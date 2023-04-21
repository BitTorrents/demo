package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping(value = "/api/menu")
    public String menu(Model model){
        model.addAttribute("menuDto",new MenuDto());
        return "/api/menu";
    }

}
