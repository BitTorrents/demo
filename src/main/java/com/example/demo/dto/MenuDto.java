package com.example.demo.dto;

import com.example.demo.constant.MenuSellStatus;
import com.example.demo.entity.FoodEntity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {

    private Long foodId; // 음식 id

    private String name; // 음식이름

    private int price; // 음식가격

    private String detail; // 음식상세설명

    private MenuSellStatus menuSellStatus; // 품절

    private int StockNumber; // 재고

    public static MenuDto fromEntity(FoodEntity food) {
        return MenuDto.builder()
                .foodId(food.getFoodId())
                .name(food.getName())
                .price(food.getPrice())
                .detail(food.getDetail())
                .menuSellStatus(food.getMenuSellStatus())
                .StockNumber(food.getStockNumber())
                .build();
    }
}
