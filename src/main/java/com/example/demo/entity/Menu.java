package com.example.demo.entity;

import com.example.demo.constant.MenuSellStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id; // 음식코드

    @Column(name = "name")
    private String name; // 음식이름

    @Column(name = "price")
    private int price; // 음식가격

    @Column(name = "foodDetail")
    private String foodDetail; // 음식상세설명

    @Lob
    @Enumerated(EnumType.STRING)
    private MenuSellStatus menuSellStatus; // 음식판매상태
}
