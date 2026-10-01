package com.kodewala.ecommerce.service;

public interface OrderService {
	
	void placeOrder(int customerId);
	void getUniqueOrderId();
	void clearingCart(int customerId);
	void viewOrder(int customerId);
	void viewAllOrders();
	void cancelOrder(int customer, int orderId);
	

}
