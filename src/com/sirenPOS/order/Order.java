package com.sirenPOS.order;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.sirenPOS.Refund.Refund;
import com.sirenPOS.database.DatabaseManager;
import com.sirenPOS.foodcourt.Customer;
import com.sirenPOS.foodcourt.MenuDescription;
import com.sirenPOS.foodcourt.Receipt;
import com.sirenPOS.foodcourt.Store;
import com.sirenPOS.payment.Payment;
import com.sirenPOS.payment.PaymentManager;
import com.sirenPOS.payment.PaymentType;
import com.sirenPOS.reservation.Reservation;
import com.sirenPOS.tax.TaxManager;

public class Order {
	private Date date;
	private Store store;

	private List<OrderedFood> orderedFoods;
	private Payment payment;
	private Reservation reservation;
	private Customer customer;
	private Refund refund;

	// normal order constructor
	public Order(Date date, Store store) {
		this.date = date;
		this.store = store;

		payment = null;
		reservation = null;
		customer = null;
		orderedFoods = new LinkedList<>();
	}

	// normal order constructor with customer
	public Order(Date date, Store store, Customer customer) {
		this(date, store);
		this.customer = customer;
	}

	// reserved order constructor
	public Order(Date date, Reservation reservation) {
		this.date = date;
		this.reservation = reservation;

		store = reservation.getStore();
		customer = reservation.getCustomer();
		payment = reservation.getPayment();
		orderedFoods = reservation.getOrderedFoods();
	}

	// add Food to orderdFoods list
	public void addFood(MenuDescription desc, int quantity) {
		OrderedFood food = new OrderedFood(quantity, desc);
		orderedFoods.add(food);
	}

	// for handle payment
	public Receipt makePayment(PaymentType type, int amount, Object info) {
		payment = PaymentManager.creatPayment(type, amount, info);
		return payment.doPayment();
	}

	// end order and save data to database
	public void endOrder() {
		DatabaseManager.getInstance().insert(this);
	}

	// update order from database
	public void updateOrder() {
		DatabaseManager.getInstance().update(this);
	}

	// make total price included tax price
	public int getTotalWithTaxInclude(TaxManager tax) {
		int total = 0;
		for (OrderedFood f : orderedFoods)
			total += f.getSubtotal();

		return tax.includeTax(total);
	}

	/* getter setter */
	public Store getStore() {
		return store;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public Payment getPayment() {
		return payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setRefund(Refund refund) {
		this.refund = refund;
	}
}
