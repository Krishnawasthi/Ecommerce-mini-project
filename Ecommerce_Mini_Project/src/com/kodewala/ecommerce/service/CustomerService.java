package com.kodewala.ecommerce.service;

import com.kodewala.ecommerce.model.Customer;

public interface CustomerService {
	
  void registerCustomer(Customer customer);	
  void searchById(int customerId);
  void viewAllcustomer();
  void viewAllCustomerDetails(int  customerId );
  void updateCustomerAddress(int customerId, String customerAddress);
  

}
