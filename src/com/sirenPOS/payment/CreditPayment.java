package com.sirenPOS.payment;

import com.sirenPOS.foodcourt.Receipt;

public class CreditPayment extends Payment {
	private String creditCardInfo;
	private int totalAmnt;
	
	public CreditPayment(int totalAmnt, String creditCardInfo) {
		super(totalAmnt, "credit");
		this.totalAmnt=totalAmnt;
		this.creditCardInfo = creditCardInfo;
	}
	
	@Override
	public Receipt doPayment() {
		Receipt receipt = new Receipt(totalAmnt, totalAmnt);
		return receipt;
	}
	@Override
	public Receipt refundPayment() {
		// TODO Auto-generated method stub
		return new Receipt(0, 0);
	}
}
