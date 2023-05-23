package com.example.demo.controller;

import com.example.demo.dto.OrderRequestDto;
import com.example.demo.dto.OrderResponseDto;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order/register")
    public OrderResponseDto registerOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.order(orderRequestDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrderResponseDto> showOrder() {
        return orderService.showOrders();
    }



}
