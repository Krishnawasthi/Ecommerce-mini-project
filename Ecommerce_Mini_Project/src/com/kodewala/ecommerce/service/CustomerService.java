package com.kodewala.ecommerce.service;

import com.kodewala.ecommerce.model.Customer;

public interface CustomerService {
	
  void registerCustomer(Customer customer);	
  void searchById(int customerId);
  void viewAllCustomer();
  void updateCustomerDetails(int customerId, Customer customer);
 
}
