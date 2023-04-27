package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping(value = "api/menu/new")
    public Long insert(@RequestBody Menu menu) {
        return menuService.save(menu);
    }
    @GetMapping(value = "api/menu/{id}")
    public Menu read(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @GetMapping(value = "api/menu/{id}/update")
    public Long update(@PathVariable Long id,@RequestBody String name,@RequestBody int price,@RequestBody String foodDetail ) {
        return menuService.update(id, name, price, foodDetail);
    }

    @GetMapping(value = "api/menu/{id}/delete")
    public Long delete(@PathVariable Long id) {
        menuService.delete(id);
        return id;
    }






}
