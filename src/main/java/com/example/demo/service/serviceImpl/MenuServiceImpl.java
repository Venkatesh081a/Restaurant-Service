package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MenuItemRequestDto;
import com.example.demo.entity.Menu;
import com.example.demo.entity.MenuItem;
import com.example.demo.repostiory.MenuItemRepository;
import com.example.demo.repostiory.MenuRepository;
import com.example.demo.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public String addMenuItem(MenuItemRequestDto menuItemRequestDto) {
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuItemName(menuItemRequestDto.getMenuItemName());
		menuItem.setDescription(menuItemRequestDto.getDescription());
		menuItem.setPrice(menuItemRequestDto.getPrice());
		Menu menu = menuRepository.findById(menuItemRequestDto.getMenuId()).get();
		menuItem.setMenu(menu);
		menuItemRepository.save(menuItem);
		return "Menu Item Details Added Successfully";
	}

	@Override
	public MenuItem getMenuItemById(Long menuItemId) {
		MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
		return menuItem;
	}
}
