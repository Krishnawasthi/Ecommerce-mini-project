package com.kodewala.ecommerce.service;

public interface CartService {
	void addToCart(int customerId, int productId, int quantity);
	void removeFromCart(int customerId, int productId);
	void increaseQuantity(int customerId, int productId);
	void decreaseQuantity(int customerId, int productId);
    void viewCart(int customerId);
    void totalCartValue(int customerId);
    
}
