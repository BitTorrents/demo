package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String userIdx;

    private String id;

    private String pw;

    private String userName;

    private String address;
}
