package com.example.demo.service;

import com.example.demo.dto.OrderFoodDto;
import com.example.demo.dto.OrderFoodResponseDto;
import com.example.demo.dto.OrderRequestDto;
import com.example.demo.dto.OrderResponseDto;
import com.example.demo.entity.Food;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderFood;
import com.example.demo.entity.Restaurant;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuService menuService;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public OrderResponseDto order(OrderRequestDto dto) {
        Long restaurantId = dto.getRestaurantId();
        OrderResponseDto orderResponseDto = new OrderResponseDto();

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 식당입니다."));

        orderResponseDto.setRestaurantName(restaurant.getName());
        orderResponseDto.setDeliveryFee(restaurant.getDeliveryFee());

        List<OrderFoodDto> orderFoodDtoList = dto.getFoods();

        Order order = new Order();
        order.setRestaurant(restaurant);
        List<OrderFood> orderFoodList = new ArrayList<>();
        List<OrderFoodResponseDto> foodResponseDtoList = new ArrayList<>();

        int totalPrice = 0;

        for (OrderFoodDto orderFoodDto : orderFoodDtoList) {
            Long foodId = orderFoodDto.getId();
            int quantity = orderFoodDto.getQuantity();

            if (quantity > 100 || quantity < 1) {
                throw new IllegalArgumentException("주문 수량은 1~100까지 입니다.");
            }

            Food food = menuRepository.findById(foodId)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음식입니다."));

            int foodPrice = food.getPrice() * quantity;
            totalPrice += foodPrice;

            OrderFood orderFood = new OrderFood(food, order, quantity);

            orderFoodList.add(orderFood);
            foodResponseDtoList.add(new OrderFoodResponseDto(food.getName(), quantity, foodPrice));
        }

        order.setOrderFoods(orderFoodList);

        orderResponseDto.setFoods(foodResponseDtoList);
        orderResponseDto.setTotalPrice(totalPrice + restaurant.getDeliveryFee());

        if (totalPrice < restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("최소 주문 금액보다 낮습니다.");
        }

        orderRepository.save(order);

        return orderResponseDto;
    }

    @Transactional
    public List<OrderResponseDto> showOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        for (Order order : orders) {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setRestaurantName(order.getRestaurant().getName());
            orderResponseDto.setDeliveryFee(order.getRestaurant().getDeliveryFee());

            List<OrderFoodResponseDto> orderFoodResponseDtoList = new ArrayList<>();
            List<OrderFood> orderFoods = order.getOrderFoods();

            int totalPrice = 0;

            for (OrderFood orderFood : orderFoods) {
                OrderFoodResponseDto orderFoodResponseDto = new OrderFoodResponseDto(
                        orderFood.getFood().getName(),
                        orderFood.getQuantity(),
                        orderFood.getFood().getPrice() * orderFood.getQuantity());

                totalPrice += orderFood.getFood().getPrice() * orderFood.getQuantity();
                orderFoodResponseDtoList.add(orderFoodResponseDto);
            }
            orderResponseDto.setFoods(orderFoodResponseDtoList);
            orderResponseDto.setDeliveryFee(order.getRestaurant().getDeliveryFee());
            orderResponseDto.setTotalPrice(totalPrice + order.getRestaurant().getDeliveryFee());

            orderResponseDtoList.add(orderResponseDto);
        }

        return orderResponseDtoList;
    }


}