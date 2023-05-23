package com.example.demo.repository;

import com.example.demo.entity.Food;
import com.example.demo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Food, Long> {

    static List<Food> findByRestaurant(Restaurant restaurant) {
        return null;
    }

    static Optional<Food> findByNameAndRestaurantId(String name, Long RestaurantId) {
        return null;
    }

    Food findByFoodId(Long foodId);

    void deleteById(Long foodId);
}
