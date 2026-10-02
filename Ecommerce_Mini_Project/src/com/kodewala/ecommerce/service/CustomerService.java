package com.kodewala.ecommerce.service;

import com.kodewala.ecommerce.model.Customer;

public interface CustomerService {
	
  void registerCustomer(Customer customer);	
  void searchById(int customerId);
  void viewAllCustomerDetails(int customerId );
  void updateCustomerDetails(int customerId, Customer customer);
 
}
