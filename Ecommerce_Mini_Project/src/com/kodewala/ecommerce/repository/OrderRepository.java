package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.kodewala.ecommerce.model.Order;

public class OrderRepository {
	List<Order> orders = new ArrayList<>(); 
	
	//adding the order product into order repository
	public void addOrder(Order order) {
		
		orders.add(order);
		
	}
	
	//returning  all the  order through a list 
	public List<Order> getAllOrder() {
		
		return orders;
	}
	
	public Order findOrderById(int orderId) {
		
		for(Order order : orders) {
			if(order.getOrderId() == orderId) {
				
				return order;
			}
			
		}
		
		return null;
	}
	
	//creating the method to gettting the all orders of the customer that are ordered by the customer
	//and we are find these bu customer Id
	
	public List<Order> findOrdersByCutomerId(int customerId) {
		
		List<Order> customerOrder = new ArrayList<>();
		
		for(Order order: orders) {
		if(order.getCustomerId() == customerId) {	
			
			customerOrder.add(order);
		    }
		}
		return customerOrder;
		
		
		
	}
	//removing order from orders list where all the orders are there 
	public void removeOrder(Order order) {
		
		orders.remove(order);
		
	}
}
