package com.sirenPOS.payment;

import com.sirenPOS.foodcourt.Receipt;

public class CashPayment extends Payment {
	private int cash;
	private int totalAmnt;
	public CashPayment(int totalAmnt, int cash) {
		super(totalAmnt, "cash");
		this.totalAmnt=totalAmnt;
		this.cash = cash;
	}
	
	@Override
	public Receipt doPayment() {
		return new Receipt(totalAmnt, cash);
	}
	@Override
	public Receipt refundPayment() {
		return new Receipt(0, 0);
	}
}
