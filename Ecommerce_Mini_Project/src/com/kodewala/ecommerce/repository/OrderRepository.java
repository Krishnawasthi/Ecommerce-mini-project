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
}
