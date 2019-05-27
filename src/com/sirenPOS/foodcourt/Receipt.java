package com.sirenPOS.foodcourt;

public class Receipt {
	private int totalPrice;
	private int amountDue;
	
	public Receipt(int totalPrice, int totalMoney) {
		this.totalPrice = totalPrice;
		amountDue = totalMoney - totalPrice;
	}
	
	public int getAmountDue() {
		return amountDue;
	}
}
