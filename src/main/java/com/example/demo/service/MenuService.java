package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null); //ok
    }

    @Transactional
    public List<Menu> findAll() {
        return menuRepository.findAll(); //ok
    }

    @Transactional
    public Long createMenu(Menu menu) {
        return menuRepository.save(menu).getId();
    }

    @Transactional
    public Long updateMenu(Long id, String name, int price, String foodDetail) {
        Menu menu = findById(id);
        menu.updateMenu(name,price,foodDetail);
        return id;
    }

    @Transactional
    public void deleteMenu(Long id) {
        Menu menu = findById(id);
        menuRepository.delete(menu);
    }
}


