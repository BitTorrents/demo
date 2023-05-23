package com.example.demo.dto;

import com.example.demo.constant.MenuSellStatus;
import com.example.demo.entity.Food;
import com.example.demo.exception.OutOfStockException;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {

    private Long foodId; // 음식 id

    private String name; // 음식이름

    private int price; // 음식가격

    private String detail; // 음식상세설명

    private MenuSellStatus menuSellStatus; // 품절여부

    private int stockNumber; // 재고

    public static MenuDto fromEntity(Food food) {
        return MenuDto.builder()
                .foodId(food.getFoodId())
                .name(food.getName())
                .price(food.getPrice())
                .detail(food.getDetail())
                .menuSellStatus(food.getMenuSellStatus())
                .stockNumber(food.getStockNumber())
                .build();
    }

    public void removeStock(int stockNumber) throws OutOfStockException {
        int restStock = this.stockNumber - stockNumber;
        if (restStock < 0){
            String message = "상품의 재고가 부족합니다. (현재 재고 수량 : " + this.stockNumber + ")";
            throw new OutOfStockException(message);
        }
        this.stockNumber = restStock;
    }
}
