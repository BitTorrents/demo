package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.entity.Food;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @RequestMapping(method = RequestMethod.GET, value = "/api/{id}")
    public Food findOneMenu(@PathVariable("id") Long id) {
        return menuService.findById(id); //ok
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/foods")
    public List<Food> getMenu() {
        return menuService.findAll(); //ok
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/menus")
    public Long createMenu(@RequestBody Food food){
        return menuService.createMenu(food); //ok
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/{id}/updates")
    public Long updateMenu(@PathVariable Long id, @RequestBody MenuDto menuDto) {
        return menuService.updateMenu(id, menuDto); //ok
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/{id}/deletes")
    public Long deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id); // ok
        return id;
    }

}
