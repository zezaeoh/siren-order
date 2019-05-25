package com.sirenPOS.order;

public class Food {
	private String name;
	private int price;
	private int quantity;
	
	public Food(MenuItem menuItem, int quantity) {
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
		this.quantity = quantity;
	}
	
}
