package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null);

    }

    @Transactional
    public Menu createMenu(Long id) {
        Menu menu = new Menu(id);
        menuRepository.save(menu);
        return menu;
    }

}


