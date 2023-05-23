package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderFoodResponseDto {

    private String name;
    private int quantity;

    private int price;

    public OrderFoodResponseDto(String name, int quantity, int price){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
