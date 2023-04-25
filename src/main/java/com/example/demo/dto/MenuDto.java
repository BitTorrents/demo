package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
public class MenuDto {

    private Long id; // 음식 id

    private String name; // 음식이름

    private int price; // 음식가격

    private String foodDetail; // 음식상세설명

    private String sellStatCd; // 품절

}
