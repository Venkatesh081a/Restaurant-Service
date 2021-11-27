package com.example.demo.service;

import com.example.demo.dto.MenuItemRequestDto;
import com.example.demo.entity.MenuItem;

public interface MenuService {

	String addMenuItem(MenuItemRequestDto menuItemRequestDto);

	MenuItem getMenuItemById(Long menuItemId);

}
