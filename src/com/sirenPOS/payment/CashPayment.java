package com.sirenPOS.payment;

import com.sirenPOS.foodcourt.Receipt;

public class CashPayment extends Payment {
	private int cash;
	
	public CashPayment(int amount, int cash) {
		super(amount, "cash");
		this.cash = cash;
	}
	
	@Override
	public Receipt doPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
