package com.example.demo.controller;

import com.example.demo.dto.RestaurantRequestDto;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.POST, value = "/restaurant/register")
    public Restaurant addRestaurant(@RequestBody RestaurantRequestDto dto){
        return restaurantService.addRestaurant(dto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants")
    public List<Restaurant> findAllRestaurant() {
        return restaurantService.findAllRestaurant();
    }

}
