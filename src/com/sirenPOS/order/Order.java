package com.sirenPOS.order;

import java.util.LinkedList;
import java.util.List;

import com.sirenPOS.MenuDesciption;

public class Order {
	List<Food> orderedFoods;
	
	public Order() {
		orderedFoods = new LinkedList<>();
	}
	
	public void addFood(MenuDesciption desc, int quantity) {
		Food food = new Food(quantity, desc);
		orderedFoods.add(food);
	}
}
