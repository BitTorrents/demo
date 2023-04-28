package com.example.demo.dto;

import com.example.demo.entity.Menu;
import lombok.*;


@Getter
@Setter
@Builder
public class MenuDto {

    private Long id; // 음식 id

    private String name; // 음식이름

    private int price; // 음식가격

    private String foodDetail; // 음식상세설명

    private String menuSellStatus; // 품절

    public static MenuDto fromEntity(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .foodDetail(menu.getFoodDetail())
                .build();

    }

}
