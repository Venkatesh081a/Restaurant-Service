package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MenuItemRequestDto;
import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuService;

@RestController
@RequestMapping("/api/v1/menuItems")
public class MenuItemController {

	@Autowired
	private MenuService menuService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addMenuItems(@RequestBody MenuItemRequestDto menuItemRequestDto){
		String status = menuService.addMenuItem(menuItemRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}
	
	@GetMapping("/get/menuItem/{menuItemId}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long menuItemId ){
	MenuItem menuItem = menuService.getMenuItemById(menuItemId);
	return ResponseEntity.status(HttpStatus.OK).body(menuItem);
	}
	
}
