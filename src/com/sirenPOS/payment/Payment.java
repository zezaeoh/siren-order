package com.sirenPOS.payment;

import com.sirenPOS.foodcourt.Receipt;

public abstract class Payment {
	private int amount;
	private String type;
	
	public Payment(int amount, String type) {
		super();
		this.amount = amount;
		this.type = type;
	}

	public abstract Receipt doPayment();
	
	/* getter setter */
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
