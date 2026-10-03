package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.CartItem;

public class CartRepository {
	// cutomerId with list of cart items
	Map<Integer, List<CartItem>> carts = new HashMap<>();

	// 1.getting the cart of the customer
	public List<CartItem> getCart(int customerId) {

		return carts.getOrDefault(customerId, new ArrayList<>());
	}
	// 2.saving the cart

	public void saveCart(int customerId, List<CartItem> cartItems) {

		carts.put(customerId, cartItems);

	}

	//3.clear customer cart (removing items from cart)
	public void clearCart(int customerId) {

		carts.remove(customerId);
	}

}
