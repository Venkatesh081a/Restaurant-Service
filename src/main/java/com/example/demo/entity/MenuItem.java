package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuItemId;
	private String menuItemName;
	private String description;
	private int price;
	@ManyToOne
	@JoinColumn(name = "menuId_fk", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Menu menu;

	public MenuItem(String menuItemName, String description, int price, Menu menu) {
		super();
		this.menuItemName = menuItemName;
		this.description = description;
		this.price = price;
		this.menu = menu;
	}

}
