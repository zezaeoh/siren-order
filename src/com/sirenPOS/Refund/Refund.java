package com.sirenPOS.Refund;

import java.util.Date;

public class Refund {
	private Date date;
	private String description;

	public Refund(Date date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
