package com.example.demo.entity;

import com.example.demo.constant.MenuSellStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "menu")
@Entity
@Getter
@Setter
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id; // 음식코드

    @Column(nullable = false)
    private String name; // 음식이름

    @Column(name = "price", nullable = false)
    private Integer price; // 음식가격

    @Column(nullable = false)
    private String foodDetail; // 음식상세설명

    @Enumerated(EnumType.STRING)
    private MenuSellStatus menuSellStatus; // 음식판매상태
}
