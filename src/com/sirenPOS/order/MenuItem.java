package com.sirenPOS.order;

public class MenuItem {
	/*
	 * TODO
	 * replace id to name?
	 */
	//private int id; 
	private String name;
	private int price;
	
	public MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
}
