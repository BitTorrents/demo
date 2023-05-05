package com.example.demo.dto;

import lombok.*;


@Getter
@Setter
public class MenuDto {

    private Long id; // 음식 id

    private String name; // 음식이름

    private int price; // 음식가격

    private String detail; // 음식상세설명

    private String menuSellStatus; // 품절

    @Builder
    public void Food(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    @Builder
    public void updateMenu(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }
}
