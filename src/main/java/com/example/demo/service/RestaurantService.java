package com.example.demo.service;

import com.example.demo.dto.RestaurantRequestDto;
import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(RestaurantRequestDto dto){
        int minOrderPrice = dto.getMinOrderPrice();
        int deliveryFee = dto.getDeliveryFee();

        checkMinOrderPrice(minOrderPrice);
        checkgetDeliveryFee(deliveryFee);

        Restaurant restaurant = Restaurant.builder()
                .name(dto.getName())
                .minOrderPrice(minOrderPrice)
                .deliveryFee(deliveryFee)
                .build();

        restaurantRepository.save(restaurant);
        return restaurant;
    }

    private void checkMinOrderPrice(int minOrderPrice){
        if(!(1000 <= minOrderPrice && minOrderPrice <= 100000)){
            throw new IllegalArgumentException("주문 허용 값이 벗어났습니다.");
        }

        if(minOrderPrice % 100 != 0){
            throw new IllegalArgumentException("100원 단위로만 입력이 가능합니다.");
        }
    }

    private void checkgetDeliveryFee(int deliveryFee){
        if(0 > deliveryFee || deliveryFee > 10000){
            throw new IllegalArgumentException("기본 배달비 허용 값이 벗어났습니다.");
        }

        if(deliveryFee % 500 != 0){
            throw new IllegalArgumentException("500원 단위로만 입력이 가능합니다.");
        }
    }

    @Transactional
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
