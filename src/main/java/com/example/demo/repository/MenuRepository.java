package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.awt.*;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long>{

    List<Menu> findByName(String name);
}
