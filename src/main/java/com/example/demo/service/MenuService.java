package com.example.demo.service;

import com.example.demo.dto.MenuDto;
import com.example.demo.entity.Food;
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
    public Food findById(Long id) {
        return menuRepository.findById(id).orElse(null); //ok
    }

    @Transactional
    public List<Food> findAll() {
        return menuRepository.findAll(); //ok
    }

    @Transactional
    public Long createMenu(Food food) {
        return menuRepository.save(food).getId();
    }

    @Transactional
    public Long updateMenu(Long id, MenuDto menuDto) {
        Food food = menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        food.updateMenu(menuDto);
        return food.getId();
    }

    @Transactional
    public void deleteMenu(Long id) {
        Food food = findById(id);
        menuRepository.delete(food);
    }

}


