package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long ordId;

    @NotNull
    private Long id;

    private MenuDto menuDto;

}
