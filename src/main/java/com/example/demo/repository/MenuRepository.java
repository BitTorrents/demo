package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

    // 음식상품 조회
    List<Menu> findByName(Long name);


}
