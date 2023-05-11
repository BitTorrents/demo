package com.example.demo.service;

import com.example.demo.dto.MenuDto;
import com.example.demo.entity.FoodEntity;
import com.example.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public MenuDto findById(Long foodId) {
        FoodEntity findById = menuRepository.findByFoodId(foodId);
        return MenuDto.fromEntity(findById);
    }

    @Transactional
    public List<MenuDto> findAllList() {
        List<FoodEntity> foodEntityList = menuRepository.findAll();
        List<MenuDto> result = foodEntityList.stream()
                .map(m-> MenuDto.fromEntity(m))
                .collect(Collectors.toList());
        return result;
    }

    @Transactional
    public Long addMenu(MenuDto menuDto) {
        FoodEntity food = FoodEntity.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .detail(menuDto.getDetail())
                .menuSellStatus(menuDto.getMenuSellStatus())
                .stockNumber(menuDto.getStockNumber())
                .build();

        FoodEntity save = menuRepository.save(food);
        return save.getFoodId();
    }

    @Transactional
    public Long updateMenu(Long foodId, MenuDto menuDto) {
        FoodEntity foodEntity = menuRepository.findById(foodId).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        foodEntity.updateMenu(menuDto);
        return foodEntity.getFoodId();
    }

    @Transactional
    public void deleteMenu(Long foodId) {
        menuRepository.deleteById(foodId);
    }

}


