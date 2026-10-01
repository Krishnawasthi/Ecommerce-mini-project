package com.kodewala.ecommerce.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.CartItem;

public class CartRepository {
	Map<Integer, List<CartItem>> carts = new HashMap<>(); 
}
