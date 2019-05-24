package com.sirenPOS.order;

import com.sirenPOS.MenuDesciption;

public class Food {
	private int quantity;
	private MenuDesciption desc;
	
	public Food(int quantity, MenuDesciption desc) {
		this.quantity = quantity;
		this.desc = desc;
	}
}
