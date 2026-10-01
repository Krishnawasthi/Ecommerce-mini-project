package com.kodewala.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private int orderId;
	private int customerId;
	private List<CartItem> items;
	private double totalAmount;
	private OrderStatus orderStatus;
	private LocalDateTime orderDate;

	public Order(int orderId, int customerId, List<CartItem> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.items = items;
		this.totalAmount = calculateTotalAmount();
		this.orderStatus = orderStatus.PLACED;
		this.orderDate = orderDate.now();
	}

	public double calculateTotalAmount() {
		double total = 0;
		for (CartItem item : items) {

			total = total + item.getProduct().getPrice() * item.getQuantity();

		}

		return total;

	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", items=" + items + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", calculateTotalAmount()=" + calculateTotalAmount() + "]";
	}

}
