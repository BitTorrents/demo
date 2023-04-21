package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "menu")
@Entity
@Data
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name; // 음식이름

    @Column
    private Integer price; // 음식가격

    @Column
    private String foodDetail; // 음식상세설명

    private int soldOut; // 품절
}
