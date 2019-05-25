package com.sirenPOS.payment;

public class PaymentManager {
	public static Payment creatPayment(PaymentType type, int amount, Object info) {
		Payment payment = null;
		
		switch (type) {
		case CASH:
			payment = new CashPayment(amount, (int) info);
			break;
		case CREDIT:
			payment = new CreditPayment(amount, (String) info);
			break;
		default:
			break;
		}
		return payment;
	}
}
