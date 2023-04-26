package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping(value = "/menu/new")
    public Long insert(@RequestBody Menu menu) {
        return menuService.save(menu);
    }
    @GetMapping("/menu/{id}")
    public Menu read(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @PostMapping("/menu/{id}/update")
    public Long update(@PathVariable Long id,@RequestBody String name,@RequestBody int price,@RequestBody String foodDetail ) {
        return menuService.update(id, name, price, foodDetail);
    }

    @PostMapping("/menu/{id}/delete")
    public Long delete(@PathVariable Long id) {
        menuService.delete(id);
        return id;
    }






}
