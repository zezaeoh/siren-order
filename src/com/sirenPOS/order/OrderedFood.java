package com.sirenPOS.order;

import com.sirenPOS.foodcourt.MenuDescription;

public class OrderedFood {
	private int quantity;
	private MenuDescription desc;
	
	public OrderedFood(int quantity, MenuDescription desc) {
		this.quantity = quantity;
		this.desc = desc;
	}

	public int getSubtotal() {
		return desc.getPrice() * quantity;
	}
}
