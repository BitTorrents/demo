package com.example.demo.controller;


import com.example.demo.dto.MenuSearchDto;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping(value = "/menu/new")
    public String menuForm(Model model){
        model.addAttribute("form", new MenuSearchDto());
        return "/menu/MenuForm";
    }
}
