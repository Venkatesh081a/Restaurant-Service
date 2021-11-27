package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {

	private List<Restaurant> restaurants;
}
