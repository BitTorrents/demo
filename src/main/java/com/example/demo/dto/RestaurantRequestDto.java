package com.example.demo.dto;

import lombok.Data;

@Data
public class RestaurantRequestDto {

    private String name;
    private int minOrderPrice;
    private int deliveryFee;


}
