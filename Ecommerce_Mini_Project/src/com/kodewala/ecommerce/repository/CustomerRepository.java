package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.Customer;

public class CustomerRepository {

	//.Storing the customer into the map with their customer id and and othrer details
	Map<Integer, Customer> customers = new HashMap<>(); 
	
	//1.Adding the customer into the map 
	public boolean addCustomers(int customerId, Customer customer) {
		if(customers.containsKey(customerId)) {
			
			return false;
		}
		customers.put(customerId, customer);
		return true;
		
	}
	
	//2.finding the customer details using customerId
	public Customer findCostomerById(int customerId) {
		
		return customers.get(customerId);
		
	}
	//3.retrieving all details of the customer
	public List<Customer> getAllCustomer() {
		
		return new ArrayList<>(customers.values());
	}
	
	
	//4.updating the details of the customer details like name, email , mobilenumber , address
	public boolean updateCustomer(int customerId, Customer updatedCustomer) {
		
	 Customer customer = customers.get(customerId);
	 if(customer != null) {
		 
		 customer.setCustomerName(updatedCustomer.getCustomerName());
		 customer.setEmail(updatedCustomer.getEmail());
		 customer.setMobile(updatedCustomer.getMobile());
		 customer.setAddress(updatedCustomer.getAddress());
		 return true;
	 }
	 else {
		 
		
		 
		 return false;
	 
	 }
			
	}
}
