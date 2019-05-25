package com.sirenPOS.order;

import java.util.List;

public class Menu {
	List<MenuItem> items;
	
	public Menu(List<MenuItem> items) {
		this.items = items;
	}
	
	
	public MenuItem choose(String name) {
		MenuItem menuItem = new MenuItem("test", 0);
		for (MenuItem each : items ) { 
			if (each.getName().equals(name)) {
				
				// return each;
				return menuItem; // for test.
			}
		}
		return menuItem;
	}
	
}
