package com.example.demo.entity;

import com.example.demo.constant.MenuSellStatus;
import com.example.demo.dto.MenuDto;
import com.example.demo.exception.OutOfStockException;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "food")
@NoArgsConstructor
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "food_id")
    private Long foodId; // 음식코드

    @Column(nullable = false)
    private String name; // 음식이름

    @Column(nullable = false)
    private int price; // 음식가격

    @Column(nullable = false)
    private String detail; // 음식상세설명

    @Lob
    @Enumerated(EnumType.STRING)
    private MenuSellStatus menuSellStatus; // 음식판매상태

    @Column(nullable = false)
    private int stockNumber;

    @Builder
    public FoodEntity(String name, int price, String detail, MenuSellStatus menuSellStatus, int stockNumber) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.stockNumber = stockNumber;
        this.menuSellStatus = menuSellStatus;
    }

    public void updateMenu(MenuDto menuDto) {
        this.name = menuDto.getName();
        this.price = menuDto.getPrice();
        this.detail = menuDto.getDetail();
        this.menuSellStatus = menuDto.getMenuSellStatus();
        this.stockNumber = menuDto.getStockNumber();
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
