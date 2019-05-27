package com.sirenPOS.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirenPOS.foodcourt.Customer;
import com.sirenPOS.foodcourt.MenuCatalog;
import com.sirenPOS.foodcourt.Store;
import com.sirenPOS.order.OrderedFood;
import com.sirenPOS.payment.CashPayment;
import com.sirenPOS.payment.Payment;
import com.sirenPOS.reservation.Reservation;

public class ReservationTest {
	private Reservation reservation;

	@Before
	public void testInit() {
		MenuCatalog menuCatalog = new MenuCatalog();
		Store store = new Store(menuCatalog);
		List<OrderedFood> orderedFoods = new ArrayList<OrderedFood>();
		Payment payment = new CashPayment(0, 0);
		Customer customer = new Customer();
		reservation = new Reservation(store, orderedFoods, payment, customer);
	}
	
	@Test
	public void testReservation() {
		assertNotNull(reservation);
	}

	@Test
	public void testApprove() {
		assertNotNull(reservation.approve());
	}

	@Test
	public void testGetStore() {
		assertNotNull(reservation.getStore());
	}

	@Test
	public void testGetOrderedFoods() {
		assertNotNull(reservation.getOrderedFoods());
	}

	@Test
	public void testGetPayment() {
		assertNotNull(reservation.getPayment());
	}

	@Test
	public void testGetCustomer() {
		assertNotNull(reservation.getCustomer());
	}

}
