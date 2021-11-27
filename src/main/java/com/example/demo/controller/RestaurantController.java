package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MenuItemResponseDto;
import com.example.demo.dto.RestaurantRequestDto;
import com.example.demo.dto.RestaurantResponseDto;
import com.example.demo.entity.MenuItem;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping("/add")
	public ResponseEntity<String> addRestaurant(@RequestBody RestaurantRequestDto restaurantDto) {
		String status = restaurantService.saveRestaurant(restaurantDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}

	@GetMapping("/name/{restaurantName}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantsByName(@PathVariable String restaurantName) {
		RestaurantResponseDto restaurntDto = restaurantService.getRestaurantsByName(restaurantName);
		return ResponseEntity.status(HttpStatus.OK).body(restaurntDto);
	}

	@GetMapping("/location/{location}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantsByLocation(@PathVariable String location) {
		RestaurantResponseDto restaurntDto = restaurantService.getRestaurantsByLocation(location);
		return ResponseEntity.status(HttpStatus.OK).body(restaurntDto);
	}

	@GetMapping("/cuisine/{cuisine}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantsByCuisine(@PathVariable String cuisine) {
		RestaurantResponseDto restaurntDto = restaurantService.getRestaurantsByCuisine(cuisine);
		return ResponseEntity.status(HttpStatus.OK).body(restaurntDto);
	}

	@GetMapping("/budget/{budget}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantsByBudget(@PathVariable int budget) {
		RestaurantResponseDto restaurntDto = restaurantService.getRestaurantsByBudget(budget);
		return ResponseEntity.status(HttpStatus.OK).body(restaurntDto);
	}

	@GetMapping("/restaurant/menuItems/{restaurantId}")
	public ResponseEntity<List<MenuItemResponseDto>> getMenuItemsByRestaurantId(@PathVariable Long restaurantId) {
		List<MenuItemResponseDto> menuItems = restaurantService.getMenuItemsByRestaurantId(restaurantId);
		return ResponseEntity.status(HttpStatus.OK).body(menuItems);
	}
}
