package com.kodewala.ecommerce.model;

public class Customer {
  //details of the customer 
	private int customerId; 
	private String customerName;
	private String email;
	private String mobile;
	private String address;
	
	//creating costructor to initialize customer details
	public Customer(int customerId, String customerName, String email, String mobile, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	//creatign getter and setter method for customer details 
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
	
	//now returning all the customer details in the form of string using toString()
		@Override
		public String toString() {
			return "Customer Details [Customer Id: "+ customerId + ", Customer Name: "+
		customerName +", Email: "+ email +", Mobile: "+ mobile + ", Address: "+ address;
			
			
		}
}
