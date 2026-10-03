package com.kodewala.ecommerce.serviceimplement;

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

	@Override
	public void addToCart(int customerId, int productId, int quantity) {
	
		Product product = productRepository.findProductById(productId);
//-----------------------------------adding product into cart--------------------------------------//	
		//IF PRODUCT NOT IN THE PRODUCT REPOSITORY
		if(product == null) {
			
			System.out.println("Product not found");
		}
		//IF QUANTITY IS LESS THAN 0
		if(quantity <= 0 ) {
			
			System.out.println("Out of Stock");
		}
		//IF CUSTOMER ADD MORE QUANTITY THAN THE PRODUCT QUANTITY
		if(quantity > product.getQuantity()){
			
			System.out.println("Inffucient Stock");
			
		}
		
		//CHECKING IF PRODUCT IS ALREADY PRESENT IN THE CART SO INCREASE THE QUANTITY
		
		else {
			List<CartItem> cart = cartRepository.getCart(customerId);
			
			boolean productAlreadyExist = false;
			
			for(CartItem item : cart) {
				if(item.getProduct().getProductId() == productId) {
					
				item.setQuantity(item.getQuantity()+ quantity);
				 productAlreadyExist = true;
				 break;
				}
				
			}
			
		//IF PRODUCT IS NOT EXIST IN THE CART
			if(!productAlreadyExist){
				
			CartItem cartItem = new CartItem(product, quantity);
			
			cart.add(cartItem);  //adding a new product cart item into cart 
			}
			
			cartRepository.saveCart(customerId, cart);
			System.out.println("Item added to cart Sucessfully");
		}
						
	}

	@Override
	public void increaseQuantity(int customerId, int productId) {
		
		
	}

	@Override
	public void decreaseQuantity(int customerId, int productId) {
		
		
	}

	@Override
	public void viewCart(int customerId) {
		
	}

	@Override
	public void totalCartValue(int customerId) {
		
		
	}
	@Override
	public void removeFromCart(int customerId, int productId) {
		
	}

}
