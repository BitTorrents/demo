package com.example.demo.dto;

import com.example.demo.constant.MenuSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuSearchDto {

    private Long id;

    private String name;

    private Integer price;

    private String foodDetail;

    private MenuSellStatus menuSellStatus;


}

