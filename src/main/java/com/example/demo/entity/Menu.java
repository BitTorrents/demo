package com.example.demo.entity;

import com.example.demo.constant.MenuSellStatus;
import com.example.demo.dto.MenuDto;
import lombok.*;

import javax.persistence.*;


@Entity
@ToString
@Getter
@Setter
@Table(name = "menu")
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu")
    private Long id; // 음식코드

    @Column(nullable = false)
    private String name; // 음식이름

    @Column(nullable = false)
    private int price; // 음식가격

    @Column(nullable = false)
    private String foodDetail; // 음식상세설명

    @Lob
    @Enumerated(EnumType.STRING)
    private MenuSellStatus menuSellStatus; // 음식판매상태

    @Builder
    public Menu(String name, int price, String foodDetail) {
        this.name = name;
        this.price = price;
        this.foodDetail = foodDetail;
    }

    public void update(String name, int price, String foodDetail){
        this.name = name;
        this.price = price;
        this.foodDetail = foodDetail;
    }
}
