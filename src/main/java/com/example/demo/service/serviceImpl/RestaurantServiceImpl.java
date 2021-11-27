package com.example.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MenuItemResponseDto;
import com.example.demo.dto.RestaurantRequestDto;
import com.example.demo.dto.RestaurantResponseDto;
import com.example.demo.entity.Menu;
import com.example.demo.entity.MenuItem;
import com.example.demo.entity.Restaurant;
import com.example.demo.repostiory.MenuItemRepository;
import com.example.demo.repostiory.MenuRepository;
import com.example.demo.repostiory.RestaurantRepository;
import com.example.demo.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public String saveRestaurant(RestaurantRequestDto restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantName(restaurantDto.getRestaurantName());
		restaurant.setLocation(restaurantDto.getLocation());
		restaurant.setCuisine(restaurantDto.getCuisine());
		restaurant.setBudget(restaurantDto.getBudget());
		restaurant.setRating(restaurantDto.getRating());
		restaurant = restaurantRepository.save(restaurant);
		Menu menu = new Menu();
		menu.setActiveFrom(restaurantDto.getActiveFrom());
		menu.setActiveTill(restaurantDto.getActiveTill());
		menu.setRestaurant(restaurant);
		menuRepository.save(menu);
		return "Restaurant Details Added Successfully";
	}

	@Override
	public RestaurantResponseDto getRestaurantsByName(String restaurantName) {
		List<Restaurant> restaurants = restaurantRepository.findByRestaurantName(restaurantName);
		RestaurantResponseDto responseDto = new RestaurantResponseDto();
		responseDto.setRestaurants(restaurants);
		return responseDto;
	}

	@Override
	public RestaurantResponseDto getRestaurantsByLocation(String location) {
		List<Restaurant> restaurants = restaurantRepository.findByLocation(location);
		RestaurantResponseDto responseDto = new RestaurantResponseDto();
		responseDto.setRestaurants(restaurants);
		return responseDto;
	}

	@Override
	public RestaurantResponseDto getRestaurantsByCuisine(String cuisine) {
		List<Restaurant> restaurants = restaurantRepository.findByCuisine(cuisine);
		RestaurantResponseDto responseDto = new RestaurantResponseDto();
		responseDto.setRestaurants(restaurants);
		return responseDto;
	}

	@Override
	public RestaurantResponseDto getRestaurantsByBudget(int budget) {
		List<Restaurant> restaurants = restaurantRepository.findByBudget(budget);
		RestaurantResponseDto responseDto = new RestaurantResponseDto();
		responseDto.setRestaurants(restaurants);
		return responseDto;
	}

	@Override
	public List<MenuItemResponseDto> getMenuItemsByRestaurantId(Long restaurantId) {
		Menu menu = menuRepository.findByRestaurantRestaurantId(restaurantId);
        List<MenuItem> menuItems = menuItemRepository.findByMenuMenuId(menu.getMenuId());
        List<MenuItemResponseDto> menuItemResponse = new ArrayList<MenuItemResponseDto>();
        menuItems.forEach(item -> {
        	MenuItemResponseDto menuItemResponseDto = new  MenuItemResponseDto();
        	menuItemResponseDto.setMenuItemId(item.getMenuItemId());
        	menuItemResponseDto.setMenuItemName(item.getMenuItemName());
        	menuItemResponseDto.setDescription(item.getDescription());
        	menuItemResponseDto.setPrice(item.getPrice());
        	menuItemResponse.add(menuItemResponseDto);
        });
		return menuItemResponse;
	}

}
