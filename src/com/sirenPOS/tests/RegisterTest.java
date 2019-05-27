package com.sirenPOS.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirenPOS.Register;
import com.sirenPOS.foodcourt.Customer;
import com.sirenPOS.foodcourt.FoodCourt;
import com.sirenPOS.foodcourt.MenuCatalog;
import com.sirenPOS.foodcourt.MenuDescription;
import com.sirenPOS.foodcourt.Receipt;
import com.sirenPOS.foodcourt.Store;
import com.sirenPOS.order.OrderedFood;
import com.sirenPOS.payment.CreditPayment;
import com.sirenPOS.payment.Payment;
import com.sirenPOS.reservation.Reservation;
import com.sirenPOS.tax.TaxManager;

public class RegisterTest {

	private static int storeId = 999;
	private Register register;
	private int totalAmnt;
	private MenuCatalog menuCatalog;
	private Store store;
	private List<OrderedFood> orderedFoods;
	private Customer customer;

	@Before
	public void testInit() throws Exception {
		MenuDescription menuDesc;
		menuCatalog = new MenuCatalog();
		store = new Store(menuCatalog);
		TaxManager tm = new TaxManager();
		FoodCourt fc = new FoodCourt();
		register = new Register(tm, fc);
		totalAmnt = 0;
		orderedFoods = new ArrayList<OrderedFood>();
		customer = new Customer();

		for (int i = 0; i < 5; i++) {
			menuDesc = new MenuDescription("menu" + i + " desc", "menu" + i, i * 100, i);
			menuCatalog.addMenuDesc(i, menuDesc);
		}

		fc.addStore(storeId, store);
	}

	@Test
	public void testMakeNewOrder() throws Exception {
		register.makeNewOrder(storeId);
		assertNotNull(register.getCurrentOrder());
	}

	@Test
	public void testRegister() {
		assertNotNull(register);
	}

	@Test
	public void testEnterFood() throws Exception {
		int menuId = 0;
		int quantity = 5;

		register.makeNewOrder(storeId);

		totalAmnt = register.enterFood(menuId, quantity);
		int totalPrice = menuCatalog.getMenuDesc(menuId).getPrice() * quantity;
		assertEquals(totalPrice, totalAmnt);
	}

	@Test
	public void testMakeCashPayment() throws Exception {
		int cashAmnt = totalAmnt + 100;

		register.makeNewOrder(storeId);

		Receipt rc = register.makeCashPayment(totalAmnt, cashAmnt);
		assertEquals(rc.getAmountDue(), cashAmnt - totalAmnt);
	}

	@Test
	public void testMakeCreditPayment() throws Exception {
		register.makeNewOrder(storeId);

		Receipt rc = register.makeCashPayment(totalAmnt, totalAmnt);
		assertEquals(rc.getAmountDue(), 0);
	}

	@Test
	public void testCancelOrder() throws Exception {
		register.makeNewOrder(storeId);
		register.cancelOrder();
		assertNull(register.getCurrentOrder());
	}

	@Test
	public void testMakeNewRefund() throws Exception {
		register.makeNewRefund();
		assertNotNull(register.getCurrentRefund());
	}

	
	@Test 
	public void testFindOrder() throws Exception { 
		register.makeNewOrder(storeId);
		Receipt rc = register.makeCashPayment(totalAmnt, totalAmnt);
		register.makeNewRefund();
		register.findOrder(0);
		assertNotNull(register.getCurrentRefund());
		
	}
	
	@Test 
	public void testRefundPayment() throws Exception {
		register.makeNewOrder(storeId);
		register.makeCashPayment(totalAmnt, totalAmnt);
		register.makeNewRefund();
		register.findOrder(0);
		
		Receipt rc = register.refundPayment();
		assertNotNull(rc); 
	 }
	  
	@Test 
	public void testAddRefundInfo() throws Exception{
		register.makeNewOrder(storeId);
		register.makeCashPayment(totalAmnt, totalAmnt);
		register.makeNewRefund();
		register.findOrder(0);
		register.refundPayment();
		try {
			register.addRefundInfo("test");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testReceiveReservation() {
		Payment payment = new CreditPayment(totalAmnt, "info");
		Reservation reservation = new Reservation(store, orderedFoods, payment, customer);
		register.receiveReservation(reservation);
		assertSame(reservation, register.getLatestReservation());
	}

	@Test
	public void testApproveReservation() throws Exception {
		Payment payment = new CreditPayment(totalAmnt, "info");
		Reservation reservation = new Reservation(store, orderedFoods, payment, customer);
		Receipt rc = register.approveReservation(reservation);
		assertNotNull(rc);
	}

	@Test
	public void testSendReservationAlert() throws Exception {
		Payment payment = new CreditPayment(totalAmnt, "info");
		Reservation reservation = new Reservation(store, orderedFoods, payment, customer);
		register.receiveReservation(reservation);
		Receipt rc = register.approveReservation(reservation);
		register.sendReservationAlert(0);

	}
}
