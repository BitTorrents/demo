package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public void saveMenu(Menu menu){
        menuRepository.save(menu);
    }

    public List<Menu> findMenu(){
        return menuRepository.findAll();
    }

}
