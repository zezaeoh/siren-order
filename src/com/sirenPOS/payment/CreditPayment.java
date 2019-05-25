package com.sirenPOS.payment;

import com.sirenPOS.foodcourt.Receipt;

public class CreditPayment extends Payment {
	private String creditCardInfo;
	
	public CreditPayment(int amount, String creditCardInfo) {
		super(amount, "credit");
		this.creditCardInfo = creditCardInfo;
	}
	
	@Override
	public Receipt doPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
