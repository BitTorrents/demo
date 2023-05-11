package com.example.demo.entity;

import com.example.demo.constant.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordId;

    @Column(name = "menu_id")
    private Long id;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


}
