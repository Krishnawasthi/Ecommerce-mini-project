package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;

import com.kodewala.ecommerce.model.Product;

public class ProductRepository {
	
	//storing all products in an arraylist
	List<Product> products = new ArrayList<>();
	
	
	//addding  products to it
	public void addProduct(Product product) {
		
		products.add(product);
	}
	//retrieve all products
	public List<Product> getAllProduct(){
		
		return products;
		
	}
	
	
	//searching product by using product ID
	public Product findProductById(int productId) {
		
		
		for(Product product : products) {
			
			if(product.getProductId() == productId) {
				
				
				return product;
			}
			
			
		}
		return null;
		
	}
	
	
	/* searching product by product Name using list becuase multiple product may have same name*/
	public List<Product> findProductByName(String productName) {
		
		List<Product> allProductByName = new ArrayList<>();
		for(Product product : products) {
			if(product.getProductName().equalsIgnoreCase(productName)) {
				
				allProductByName.add(product);
			}
			
		}
		
		return allProductByName;
	}
	
	/* searching product by product category using list becuase multiple product may have same category */
	
 	public List<Product> findProductByCategory(String category ) {
 		
 		List<Product> productByCategory = new ArrayList<>();
 		
 		for(Product product : products) {
 			if(product.getCategory().equalsIgnoreCase(category)) {
 				
 				productByCategory.add(product);
 				
 			}
 			
 		}
		return productByCategory;
 		
 	}
 	
		//updating product price through product Id
 	public boolean updateProductPrice(int productId, double newPrice) {
 		
 		for(Product product : products) {
 			if(product.getProductId() == productId) {
 			
 			product.setPrice(newPrice);
 			return true;
 			
 			}
 			
 		}
 		return false;
 	}
 	//updatig product quantity  the product of the list 
 	public boolean updateProductQuantity(int productId,int quantity) {
 		
 		Product product = findProductById(productId);
 		if(product != null) {
 			
 		product.setQuantity(quantity);
 		return true;
 			
 		}
 		
 		return false;
 	}
 	
 
 	//deleteing the product from the list
 	
 	public boolean deleteProduct(int productId) {
 		Product product = findProductById(productId);
 		if(product != null) {
 			
 			products.remove(product);
 			return true;
 			
 		}
		return false;
 		
 		
 		
 	}

}
