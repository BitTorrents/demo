package com.example.demo.service;

import com.example.demo.dto.MenuDto;
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
        return menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않다"));
    }

    @Transactional
    public Long save(Menu menu) {
        return menuRepository.save(menu).getId();
    }

    @Transactional
    public Long update(Long id, String name, int price, String foodDetail) {
        Menu menu = findById(id);
        menu.update(name,price,foodDetail);
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Menu menu = findById(id);
        menuRepository.delete(menu);
    }



}
