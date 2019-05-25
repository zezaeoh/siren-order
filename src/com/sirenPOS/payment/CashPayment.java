package com.sirenPOS.payment;

public class CashPayment extends Payment {
	int cashAmount;
	int amountDue;
	
	public CashPayment(int totalAmount, int cashAmount) {
		super(totalAmount);
		this.cashAmount = cashAmount;
		this.amountDue = totalAmount - cashAmount;
	}

	public boolean makePayment() {
		
		/* 
		 * TODO
		 * mock-up test..return type void?
		 */
		
		boolean ret = true;
	
		if (!enterReceivedCash(cashAmount)) 
			ret = false;
		
		return ret;
		
	}
	private boolean enterReceivedCash(int cashAmount) {
		
		boolean ret = true;
		
		
		return ret;
		
	}
}
