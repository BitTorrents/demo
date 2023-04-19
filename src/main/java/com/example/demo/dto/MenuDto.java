package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuDto {

    private Long menu_Id; // 음식 id

    private String name; // 음식이름

    private Integer price; // 음식가격

    private String foodDetail; // 음식상세설명

    private int soldOut; // 품절

}
