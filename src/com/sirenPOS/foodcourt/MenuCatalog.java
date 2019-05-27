package com.sirenPOS.foodcourt;

import java.util.HashMap;
import java.util.Map;

public class MenuCatalog {
	private Map<Integer, MenuDescription> table;
	
	public MenuCatalog() {
		table = new HashMap<>();
	}
	
	public MenuDescription getMenuDesc(int menuId) {
		if(table.containsKey(menuId))
			return table.get(menuId);
		return null;
	}
	
	public void addMenuDesc(int menuId, MenuDescription menuDesc) {
		table.put(menuId, menuDesc);
	}
}
