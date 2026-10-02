package com.kodewala.ecommerce.serviceimplement;

import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.repository.CustomerRepository;
import com.kodewala.ecommerce.service.CustomerService;

public class CustomerServiceImp implements CustomerService{
    
	CustomerRepository customerRepository;
	public CustomerServiceImp(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	@Override
	public void registerCustomer(Customer customer) {
		
	}
	@Override
	public void searchById(int customerId) {
	
	}
	@Override
	public void viewAllCustomerDetails(int customerId) {
		
		
	}
	@Override
	public void updateCustomerDetails(int customerId, Customer customer) {
		
		
	}

}