package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MenuController {

    private final MenuService menuService;

    @GetMapping(value = "/{id}")
    public Menu findOneMenu(@PathVariable("id") Long id) {
        return menuService.findById(id); //ok
    }

    @PostMapping(value = "/create/{id}")
    public Long createMenu(@PathVariable("id") Long id) {
        return menuService.createMenu(id).getId();
    }

}
