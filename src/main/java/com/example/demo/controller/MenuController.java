package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @RequestMapping(value = "/menu/new", method = RequestMethod.GET)
    public Long insert(@RequestBody Menu menu) {
        return menuService.save(menu);
    }
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public Menu read(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @RequestMapping(value = "/menu/{id}/update", method = RequestMethod.GET)
    public Long update(@PathVariable Long id,@RequestBody String name,@RequestBody int price,@RequestBody String foodDetail ) {
        return menuService.update(id, name, price, foodDetail);
    }

    @RequestMapping(value = "/menu/{id}/delete", method = RequestMethod.GET)
    public Long delete(@PathVariable Long id) {
        menuService.delete(id);
        return id;
    }






}
