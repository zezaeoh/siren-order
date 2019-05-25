package com.sirenPOS.payment;

public class CardPayment extends Payment {
	private int cardNum;

	public CardPayment(int totalAmount, int cardNum) {
		super(totalAmount);
		this.cardNum = cardNum;
	}

	public boolean makePayment() {
		
		boolean ret = true;
		
		if (!enterCardInformation(cardNum)) 
			ret = false;
		
		return ret;
		
	}
	
	private boolean enterCardInformation(int cardNum) {
		
		boolean ret = true;
		
		return ret;
		
	}
}
