package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.Customer;

public class CustomerRepository {

	//Storing the customer into the map with their customer id and and othrer details
	Map<Integer, Customer> customers = new HashMap<>(); 
	
	//Adding the customer into the map 
	public void addCustomers(int customerId, Customer customer) {
		
		customers.put(customerId, customer);
		
	}
	
	//finding the customer details using customerId
	public Customer findCostomerById(int customerId) {
		
		
	    for(Map.Entry<Integer, Customer> customer : customers.entrySet()){
			
			if(customer.getKey() == customerId) {
				
				return customer.getValue();
			}
		}
		
		
		return null;
		
		
	}
	//retrieving all details of the customer
	public List<Customer> getAllCustomer() {
		
		return new ArrayList<>(customers.values());
	}
}
