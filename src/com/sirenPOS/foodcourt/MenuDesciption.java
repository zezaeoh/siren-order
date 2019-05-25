package com.sirenPOS.foodcourt;

public class MenuDesciption {
	private String longDescripton, shortDescription;
	private int price;
	private int menuId;
	
	public MenuDesciption(String longDescripton, String shortDescription, int price, int menuId) {
		this.longDescripton = longDescripton;
		this.shortDescription = shortDescription;
		this.price = price;
		this.menuId = menuId;
	}

	public int getPrice() {
		return price;
	}

}
