package com.kodewala.ecommerce.model;

public class CartItem  {
   
	private Product product;
	private double quantity;
	
	
	
	public CartItem(Product product, double quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public double calculateTotalPrice() {
		return product.getPrice() * quantity;
		
		
	}
	//generate getter and setter for Product and quantity
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	// returning the total price from here
     public double getTotalPrice() {
	        return calculateTotalPrice();
	  }

	
	
	//returning cart items through string
	@Override
	public String toString() {
		return "CartItem [ Product: " + product.getProductName() +", Price: "+ product.getPrice()+", Quantity: "+ quantity +", Total Price: "+ calculateTotalPrice()+"]";
		
		
	}
	

}
