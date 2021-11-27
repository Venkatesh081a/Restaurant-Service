package com.example.demo.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	List<Restaurant> findByRestaurantName(String restaurantName);

	List<Restaurant> findByLocation(String location);

	List<Restaurant> findByCuisine(String cuisine);
	
	List<Restaurant> findByBudget(int budget);
}
