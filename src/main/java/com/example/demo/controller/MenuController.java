package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/localhost:3307/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;




}
