package com.kodewala.ecommerce.main;

import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.model.Product;

public class EcommerceApplication {

	public static void main(String[] args) {
		Product p = new Product(104, "Iphone 17", "Mobile",120000, 1, "Apple");
		System.out.println(p);
	
 
		Customer c = new Customer("krish2123","Krishna", "krisjnaAwasthi@gmail.com", "803533429"," btm layout second stage");
		System.out.println(c);
		
		
	}
	
}