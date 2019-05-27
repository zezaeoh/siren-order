package com.sirenPOS.reservation;

import java.util.Date;
import java.util.List;

import com.sirenPOS.foodcourt.Customer;
import com.sirenPOS.foodcourt.Receipt;
import com.sirenPOS.foodcourt.Store;
import com.sirenPOS.order.OrderedFood;
import com.sirenPOS.payment.Payment;

public class Reservation {
	private Date date;
	private Store store;
	private List<OrderedFood> orderedFoods;
	private Payment payment;
	private Customer customer;
	
	// reservation have to generated with the following information
	public Reservation(Store store, List<OrderedFood> orderedFoods, Payment payment, Customer customer) {
		date = new Date();
		this.store = store;
		this.orderedFoods = orderedFoods;
		this.payment = payment;
		this.customer = customer;
	}
	
	public Receipt approve() {
		return payment.doPayment();
	}
	
	/* getter setter */
	public Store getStore() {
		return store;
	}
	
	public List<OrderedFood> getOrderedFoods() {
		return orderedFoods;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
