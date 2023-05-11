package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @RequestMapping(method = RequestMethod.GET, value = "/api/{foodId}")
    public MenuDto findOneMenu(@PathVariable Long foodId) {
        return menuService.findById(foodId); //ok
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/menus")
    public List<MenuDto> getAllMenu() {
       return menuService.findAllList(); //ok
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/add")
    public Long addMenu(@RequestBody MenuDto menuDto){
       return menuService.addMenu(menuDto); //ok
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/update/{foodId}")
    public Long updateMenu(@PathVariable Long foodId, @RequestBody MenuDto menuDto) {
        return menuService.updateMenu(foodId, menuDto); //ok
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/delete/{foodId}")
    public void deleteMenu(@PathVariable Long foodId) {
         menuService.deleteMenu(foodId); //ok
    }

}
