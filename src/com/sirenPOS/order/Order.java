package com.sirenPOS.order;

import java.util.Date;
import java.util.List;

import com.sirenPOS.payment.CardPayment;
import com.sirenPOS.payment.CashPayment;
import com.sirenPOS.payment.Payment;

public class Order {
	
	int orderNo = 1;
	Date date;
	int totalAmount;
	Payment payment;
	int cardNumber;
	int cashAmount;
	List<Food> orderList;
	
	Order(Date date) {
		this.orderNo++;
		this.date = date;
	}
	
	public void enterFood(Menu menu, String menuName, int quantity) {
		MenuItem menuItem = menu.choose(menuName);
		Food food = new Food(menuItem, quantity);
		orderList.add(food);
	}
	
	public void makeNewOrder() {

		
		if (cardNumber != 0) {
			// Payment type: card
			payment = new CardPayment(totalAmount,cardNumber);
		} else {
			// Payment type: cash
			payment = new CashPayment(totalAmount, cashAmount);
		}
	}
	
	
}
