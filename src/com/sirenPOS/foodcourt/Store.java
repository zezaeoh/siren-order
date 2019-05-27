package com.sirenPOS.foodcourt;

public class Store {
	private MenuCatalog menuCatalog;
	
	public Store(MenuCatalog menuCatalog) {
		this.menuCatalog = menuCatalog;
	}
	public MenuCatalog getMenuCatalog() {
		return menuCatalog;
	}

}
