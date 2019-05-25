package com.sirenPOS.foodcourt;

import java.util.List;
import java.util.Map;

import com.sirenPOS.order.Order;

public class FoodCourt {
	private Map<Integer, Store> stores;
	private List<Order> completedOrders;
	
	public Store getStore(int storeId) {
		if(stores.containsKey(storeId))
			return stores.get(storeId);
		return null;
	}
	
	public void addCompletedOrder(Order order) {
		completedOrders.add(order);
	}

	public Order getOrder(int orderId) {
		Order order = null;
		try {
			order = completedOrders.get(orderId);
		} catch (Exception e) {
		}
		return order;
	}
}
