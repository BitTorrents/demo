package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MenuController {

    private final MenuService menuService;


    @GetMapping(value = "/{id}")
    public Menu findOneMenu(@PathVariable("id") Long id) {
        return menuService.findById(id); //ok
    }

    @GetMapping(value = "/menus")
    public List<Menu> getMenu() {
        return menuService.findAll(); //ok
    }

    @PostMapping(value = "/create")
    public Long createMenu(@RequestBody Menu menu){
        return menuService.createMenu(menu); //ok
    }

    @PostMapping(value = "/{id}/update")
    public Long updateMenu(@PathVariable Long id, @RequestBody String name, @RequestBody int price, @RequestBody String foodDetail){
        return menuService.updateMenu(id,name,price,foodDetail);
    }

    @PostMapping(value = "/{id}/delete")
    public Long deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id); // ok
        return id;
    }

}
