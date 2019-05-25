package com.sirenPOS.payment;

import java.util.ArrayList;

import com.sirenPOS.order.Menu;

abstract public class Payment {
	int totalAmount;
	
	Payment(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public abstract boolean makePayment();
	
	// calcuateTax?
}
