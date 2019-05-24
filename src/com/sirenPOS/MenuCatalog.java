package com.sirenPOS;

import java.util.HashMap;
import java.util.Map;

public class MenuCatalog {
	Map<Integer, MenuDesciption> table;
	
	public MenuCatalog() {
		table = new HashMap<>();
	}
	
	public MenuDesciption getMenuDesc(int menuId) {
		if(table.containsKey(menuId))
			return table.get(menuId);
		return null;
	}

}
