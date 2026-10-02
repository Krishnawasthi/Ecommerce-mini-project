package com.kodewala.ecommerce.serviceimplement;

import java.util.List;

import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.repository.CustomerRepository;
import com.kodewala.ecommerce.service.CustomerService;

public class CustomerServiceImp implements CustomerService{
    
	CustomerRepository customerRepository;
	public CustomerServiceImp(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	//addig the customer into the map
	@Override
	public void registerCustomer(Customer customer) {
		boolean result = customerRepository.addCustomers(customer.getCustomerId(), customer);
		
		if(result) {
			
			System.out.println(" customers added successfully");
		}
		else {
			
			System.out.println("Customer ID is already exist");
		}
		
	}
	
	//fidning the cusotmer by its ID
	@Override
	public void searchById(int customerId) {
		
	Customer 	customer = customerRepository.findCostomerById(customerId);
	if(customer != null) {
		
		System.out.println(customer);
	}
	else {
		
		
		System.out.println("Customer Not Found");
	}
					
	
	}
	
	//acessing the all the deatails of constomer
	@Override
	public void viewAllCustomer() {
		
		List<Customer> customer = customerRepository.getAllCustomer();
		System.out.println(customer);
		
	}
	@Override
	public void updateCustomerDetails(int customerId, Customer customer) {
		
	 boolean result  =	customerRepository.updateCustomer(customerId, customer);
	 if(result) {
		 
		 System.out.println("customer detail updated successfully");
	 }
	 else {
		 
		 System.out.println("customer not found");
	     }
		
	}

}