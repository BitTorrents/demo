package com.example.demo.service;

import com.example.demo.dto.MenuDto;
import com.example.demo.dto.MenuRequestDto;
import com.example.demo.entity.Food;
import com.example.demo.entity.Restaurant;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public MenuDto findById(Long foodId) {
        Food findById = menuRepository.findByFoodId(foodId);
        return MenuDto.fromEntity(findById);
    }

    @Transactional
    public List<MenuDto> findAllList() {
        List<Food> foodList = menuRepository.findAll();
        List<MenuDto> result = foodList.stream()
                .map(m-> MenuDto.fromEntity(m))
                .collect(Collectors.toList());
        return result;
    }

    @Transactional
    public Long addMenu(MenuDto menuDto) {
        Food food = Food.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .detail(menuDto.getDetail())
                .menuSellStatus(menuDto.getMenuSellStatus())
                .stockNumber(menuDto.getStockNumber())
                .build();

        Food save = menuRepository.save(food);
        return save.getFoodId();
    }

    @Transactional
    public Long updateMenu(Long foodId, MenuDto menuDto) {
        Food food = menuRepository.findById(foodId).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        food.updateMenu(menuDto);
        return food.getFoodId();
    }

    @Transactional
    public void deleteMenu(Long foodId) {
        menuRepository.deleteById(foodId);
    }

    @Transactional
    public void registerFood(Long restaurantId, List<MenuRequestDto> menuRequestDtoList) {

        Optional<Restaurant> found = restaurantRepository.findAllById(restaurantId);

        checkRestaurant(found);
        Restaurant restaurant = found.get();

        for (MenuRequestDto menuRequestDto : menuRequestDtoList){
            String foodName = menuRequestDto.getName();
            int price = menuRequestDto.getPrice();

            checkOverlapFood(restaurant, foodName);

            checkFoodPrice(price);

            Food food = Food.builder()
                    .name(foodName)
                    .price(price)
                    .restaurant(restaurant)
                    .build();

            menuRepository.save(food);
        }
    }

    private void checkRestaurant(Optional<Restaurant> restaurantEntity){
        if(!restaurantEntity.isPresent())
            throw new IllegalArgumentException("존재하지 않는 레스토랑입니다.");
    }


    private void checkOverlapFood(Restaurant restaurant, String name){
        Optional<Food> found = MenuRepository.findByNameAndRestaurantId(name, restaurant.getId());
        if(found.isPresent())
            throw new IllegalArgumentException("중복된 이름의 메뉴가 존재합니다요.");
    }


    private void checkFoodPrice(int price){
        if (price < 100)
            throw new IllegalArgumentException("음식 가격 100원을 초과해주세요.");

        if (price > 1000000)
            throw new IllegalArgumentException("음식 가격이 1,000,000원을 초과 하였습니다.");

        if (price % 100 > 0)
            throw new IllegalArgumentException("음식 가격을 100원 단위로만 입력해주세요.");
    }


    @Transactional
    public List<Food> findAllFoods(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("등록된 상점이 아닙니다."));

        return MenuRepository.findByRestaurant(restaurant);
    }
}


