package com.example.demo.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	Menu findByRestaurantRestaurantId(Long restaurantId);
}
