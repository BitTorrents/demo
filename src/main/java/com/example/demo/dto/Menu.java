package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Menu {

    private String restaurant_Id; // 음식점

    private Long menu_Id; // 음식 id

    private String name; // 음식이름

    private Integer price; // 음식가격

    private String foodDetail; // 음식상세설명

    private Integer quantity; // 수량

    private int soldOut; // 품절

}
