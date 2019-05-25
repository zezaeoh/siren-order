package com.sirenPOS;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import com.sirenPOS.Refund.Refund;
import com.sirenPOS.foodcourt.FoodCourt;
import com.sirenPOS.foodcourt.MenuCatalog;
import com.sirenPOS.foodcourt.MenuDesciption;
import com.sirenPOS.foodcourt.Receipt;
import com.sirenPOS.order.Order;
import com.sirenPOS.payment.PaymentType;
import com.sirenPOS.reservation.Reservation;
import com.sirenPOS.tax.TaxManager;

public class Register {
	private Order currentOrder;
	private Refund currentRefund;
	private TaxManager taxManager;
	private FoodCourt foodCourt;
	private Queue<Reservation> reservationWaitingQueue;
	
	public Register(TaxManager tm, FoodCourt fc) {
		currentOrder = null;
		currentRefund = null;
		reservationWaitingQueue = new LinkedList<>();
		
		taxManager = tm;
		foodCourt = fc;
	}
	
	/* for Order and Sale */
	public void makeNewOrder(int storeId) throws Exception {
		if(currentRefund != null)
			throw new Exception("You can not proceed during the refund process.");
		if(currentOrder != null)
			throw new Exception("There is already pending order!");
		
		currentOrder = new Order(new Date(), foodCourt.getStore(storeId));
	}
	
	public int enterFood(int menuId, int quantity) throws Exception{
		if(currentOrder == null)
			throw new Exception("There is no ongoing order!");
		
		MenuCatalog catalog = currentOrder.getStore().getMenuCatalog();
		MenuDesciption desc = catalog.getMenuDesc(menuId);
		
		currentOrder.addFood(desc, quantity);
		return currentOrder.getTotalWithTaxInclude(taxManager);
	}
	
	public void cancelOrder() throws Exception{
		if(currentOrder == null)
			throw new Exception("there is no ongoing order!");
		
		currentOrder = null;
	}
	
	public Receipt makeCreditPayment(int amount, String creditCardInfo) throws Exception{
		if(currentOrder == null)
			throw new Exception("there is no ongoing order!");
		
		Receipt rc = currentOrder.makePayment(PaymentType.CREDIT, amount, creditCardInfo);
		completOrder();
		return rc;
	}
	
	public Receipt makeCashPayment(int amount, int cash) throws Exception{ // cash means the money paid by the customer.
		if(currentOrder == null)
			throw new Exception("there is no ongoing order!");
		
		Receipt rc = currentOrder.makePayment(PaymentType.CASH, amount, cash);
		completOrder();
		return rc;
	}
	
	/* for refund */
	public void makeNewRefund() throws Exception{
		if(currentOrder != null)
			throw new Exception("You can not proceed during the order process.");
		if(currentRefund != null)
			throw new Exception("There is already pending refund!");
		
		currentRefund = new Refund(new Date());
	}
	
	public void findOrder(int orderId) throws Exception{
		if(currentRefund == null)
			throw new Exception("There is no ongoing refund!");
		
		currentOrder = foodCourt.getOrder(orderId);
		if(currentOrder == null)
			throw new Exception("This is invalid order id!");
		
		currentOrder.setRefund(currentRefund);
	}
	
	public Receipt refundPayment() throws Exception{
		if(currentRefund == null)
			throw new Exception("There is no ongoing refund!");
		if(currentOrder == null)
			throw new Exception("There is no ongoing order!");
		
		return currentOrder.getPayment().refundPayment();
	}
	
	public void addRefundInfo(String description) throws Exception{ // description -> why customer did refund?
		if(currentRefund == null)
			throw new Exception("There is no ongoing refund!");
		if(currentOrder == null)
			throw new Exception("There is no ongoing order!");
		
		currentRefund.setDescription(description);
		currentOrder.updateOrder();
		currentRefund = null;
		currentOrder = null;
	}
	
	/* for reservation and approval  */
	// reservation came from mobile application
	public void receiveReservation(Reservation reservation) {
		reservationWaitingQueue.add(reservation);
	}
	
	public Reservation getLatestReservation() {
		return reservationWaitingQueue.poll();
	}
	
	public Receipt approveReservation(Reservation reservation) throws Exception{
		if(currentOrder != null)
			throw new Exception("there is already pending order!");
		
		Receipt rc = reservation.approve();
		currentOrder = new Order(new Date(), reservation);
		completOrder();
		return rc;
	}
	
	public void sendReservationAlert(int orderId) {
		
	}
	
	/* for code readability */
	private void completOrder() {
		currentOrder.endOrder();
		foodCourt.addCompletedOrder(currentOrder);
		currentOrder = null;
	}
}
