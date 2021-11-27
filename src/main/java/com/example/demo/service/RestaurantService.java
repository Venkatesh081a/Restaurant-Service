package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MenuItemResponseDto;
import com.example.demo.dto.RestaurantRequestDto;
import com.example.demo.dto.RestaurantResponseDto;
import com.example.demo.entity.MenuItem;

public interface RestaurantService {

	String saveRestaurant(RestaurantRequestDto restaurantDto);

	RestaurantResponseDto getRestaurantsByName(String restaurantName);

	RestaurantResponseDto getRestaurantsByLocation(String location);

	RestaurantResponseDto getRestaurantsByCuisine(String cuisine);

	RestaurantResponseDto getRestaurantsByBudget(int budget);

	List<MenuItemResponseDto> getMenuItemsByRestaurantId(Long restaurantId);

	

}
