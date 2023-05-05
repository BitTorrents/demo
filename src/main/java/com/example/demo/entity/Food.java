package com.example.demo.entity;

import com.example.demo.constant.MenuSellStatus;
import com.example.demo.dto.MenuDto;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "food")
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id; // 음식코드

    @Column(nullable = false)
    private String name; // 음식이름

    @Column(nullable = false)
    private int price; // 음식가격

    @Column(nullable = false)
    private String detail; // 음식상세설명

    @Lob
    @Enumerated(EnumType.STRING)
    private MenuSellStatus menuSellStatus; // 음식판매상태

    @Builder
    public Food(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    @Builder
    public void updateMenu(MenuDto menuDto) {
        this.name = menuDto.getName();
        this.price = menuDto.getPrice();
        this.detail = menuDto.getDetail();
    }



}
