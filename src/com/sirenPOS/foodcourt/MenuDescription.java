package com.sirenPOS.foodcourt;

public class MenuDescription {
	private String longDescripton, shortDescription;
	private int price;
	private int menuId;
	
	public MenuDescription(String longDescripton, String shortDescription, int price, int menuId) {
		this.longDescripton = longDescripton;
		this.shortDescription = shortDescription;
		this.price = price;
		this.menuId = menuId;
	}

	public int getPrice() {
		return price;
	}

}
