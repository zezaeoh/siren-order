package com.sirenPOS.alert;

import com.sirenPOS.foodcourt.Customer;

public class AlertManager {
	public static AlertManager instance;
	
	private AlertManager() {
		// for singleton design pattern
	}
	
	public static synchronized AlertManager getInstance() {
		return (instance == null) ? new AlertManager(): instance;
	}
	
	public void sendAlert(Customer customer) {
		// send alert to customer
	}
}
