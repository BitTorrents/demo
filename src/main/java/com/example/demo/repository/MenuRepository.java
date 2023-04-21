package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

    // 음식 Id로 상품 조회
    List<Menu> findAllById(Long Id);


}
