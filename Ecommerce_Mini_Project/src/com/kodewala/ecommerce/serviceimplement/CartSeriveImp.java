package com.kodewala.ecommerce.serviceimplement;

import java.util.Iterator;
import java.util.List;

import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.CartRepository;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.CartService;

public class CartSeriveImp implements CartService{
	//accessging the cart repo and product repo where all the products are stored
	private CartRepository cartRepository;
	private ProductRepository productRepository;
	
	

	public CartSeriveImp(CartRepository cartRepository, ProductRepository productRepository) {
		super();
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
	}
	
	//adding item to cart

	@Override
	public void addToCart(int customerId, int productId, int quantity) {
	
		Product product = productRepository.findProductById(productId);
//-----------------------------------adding product into cart--------------------------------------//	
		//IF PRODUCT NOT IN THE PRODUCT REPOSITORY
		if(product == null) {
			
			System.out.println("Product not found");
			return;
		}
		//IF QUANTITY IS LESS THAN 0
		if(quantity <= 0 ) {
			
			System.out.println("Out of Stock");
			return;
		}
		
		
		
		//CHECKING IF PRODUCT IS ALREADY PRESENT IN THE CART SO INCREASE THE QUANTITY
		
		else {
			List<CartItem> cart = cartRepository.getCart(customerId);
			
			boolean productAlreadyExist = false;
			
			for(CartItem item : cart) {
				if(item.getProduct().getProductId() == productId) {
					
					//IF CUSTOMER ADD MORE QUANTITY THAN THE PRODUCT QUANTITY
					
					if(item.getQuantity() + quantity > product.getQuantity()) {
						
						
						System.out.println("Insufficient Stock");
	                    return;
					}
					
				item.setQuantity(item.getQuantity()+ quantity);
				 productAlreadyExist = true;
				 break;
				}
				
			}
			
		//IF PRODUCT IS NOT EXIST IN THE CART
			if(!productAlreadyExist){
				
				if(quantity > product.getQuantity()) {
			        System.out.println("Insufficient Stock");
			        return;
			    }
			CartItem cartItem = new CartItem(product, quantity);
			
			cart.add(cartItem);  //adding a new product cart item into cart 
			}
			
			cartRepository.saveCart(customerId, cart);
			System.out.println("Item added to cart Successfully");
		}
						
	}
	
	//increaging the quantity of the items in the cart 

	@Override
	public void increaseQuantity(int customerId, int productId) {
		List<CartItem> cart = cartRepository.getCart(customerId);
		/*	Increase the quantity of a product already present in the customer's cart by 1,
		but only when enough stock is available*/
		for(CartItem item : cart) {
			
			if(item.getProduct().getProductId() == productId) {
				
				item.setQuantity(item.getQuantity() + 1);
				cartRepository.saveCart(customerId, cart);
				System.out.println("Quantity Increased");
				return;
				
				
			}
			
			
		}
		
	}
	
	//decreaging the quantity of the items in the cart 

	@Override
	public void decreaseQuantity(int customerId, int productId) {
		List<CartItem> cart = cartRepository.getCart(customerId);
		
		for(CartItem item: cart) {
			
			if(item.getProduct().getProductId() == productId)
			{
				if(item.getQuantity() > 1) {
				item.setQuantity(item.getQuantity() - 1);
				System.out.println("Quantity Decreased");
				
				
				}else {
					
					System.out.println("Quantity can not be less than 1");
				}
				return;
			}
			
			
		}
		
		
	}
	
	//item  presnt in the perticular cart 

	@Override
	public void viewCart(int customerId) {
		
		List<CartItem> cart = cartRepository.getCart(customerId);
		
		if(cart.isEmpty()) {
			
			System.out.println("Cart is Empty");
			return;
		}
		for(CartItem item: cart) {
			
			System.out.println(item);
		}
		
	}
   //total value of cart
	@Override
	public void totalCartValue(int customerId) {
		
		List<CartItem> cart = cartRepository.getCart(customerId);
		double total = 0;
		
		for(CartItem item : cart) {
			
			total = total + item.getTotalPrice();
		}
		
		System.out.println("Total value of cart "+ total );
	}
	
	//removing the the cart
	//Iterator, It is the safe way to remove an item while iterating through a list.
	@Override
	public void removeFromCart(int customerId, int productId) {
		
		List<CartItem> cart = cartRepository.getCart(customerId);
		Iterator<CartItem> iterator = cart.iterator();
		while(iterator.hasNext()) {
			
			
			CartItem item =  iterator.next();
			if(item.getProduct().getProductId() == productId) {
				
				iterator.remove();
				cartRepository.saveCart(customerId, cart);
				
				System.out.println("Product Remove From the cart");
				
				return;
				
				
			}
		}
		
			
			System.out.println("Product not found in cart");
		
		
	}

}
