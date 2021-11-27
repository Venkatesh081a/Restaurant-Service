package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDto {

	private String restaurantName;
	private String location;
	private String cuisine;
	private int budget;
	private double rating;
	private String activeFrom;
	private String activeTill;
}
