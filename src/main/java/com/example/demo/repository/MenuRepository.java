package com.example.demo.repository;

import com.example.demo.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<FoodEntity, Long> {


    FoodEntity findByFoodId(Long foodId);

    void deleteById(Long foodId);
}
