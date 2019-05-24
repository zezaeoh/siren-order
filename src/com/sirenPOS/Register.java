package com.sirenPOS;

import com.sirenPOS.order.Order;

public class Register {
	private Order currentOrder;
	private MenuCatalog menuCatalog;
	
	public Register(MenuCatalog mc) {
		currentOrder = null;
		menuCatalog = mc;
	}
	
	public void makeNewOrder() throws Exception {
		if(currentOrder != null)
			throw new Exception("there is already pending order!");
		
		currentOrder = new Order();
	}
	
	public void enterFood(int menuId, int quantity) throws Exception{
		if(currentOrder == null)
			throw new Exception("there is no ongoing order!");
		MenuDesciption desc = menuCatalog.getMenuDesc(menuId);
		currentOrder.addFood(desc, quantity);
	}
}
