package com.kodewala.ecommerce.serviceimplement;

import java.util.List;

import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.ProductService;
  /*In  this file we are implementing the methods that set by service interface 
   * called all the methods from ProductRepsitory where we have store the product and write the logic for operation on product*/
public class ProductServiceImp implements ProductService {
     
	private ProductRepository productRepository;
	
	public ProductServiceImp(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(Product product) {
		
		productRepository.addProduct(product);
		System.out.println("Product Added Successfully");
	}

	@Override
	public void viewAllProduct() {
		
		List<Product> products = productRepository.getAllProduct();
		
		for(Product product: products) {
			
		System.out.println(product);
		
		}
		
	}

	@Override
	public void searchProductbyId(int productId) {
		
		Product product = productRepository.findProductById(productId);
		if(product != null) {
			
			System.out.println(product);
			
		}
		else {
			
			System.out.println("Product not found");
		}
				
		
	}

	@Override
	public void searchProductbyName(String productName) {
		
	  List<Product> products = productRepository.findProductByName(productName);
	  for(Product product : products) {
	
	    System.out.println(product);
	  }
	 
	}

	@Override
	public void searchProductbyCategory(String category) {
		 List<Product> products = productRepository.findProductByCategory(category);
		 
		 for(Product product : products) {
				
			    System.out.println(product);
			  }
			 
	}

	@Override
	public void updateProductPrice(int productId, double price) {
		
		Boolean result = productRepository.updateProductPrice(productId, price);
		if(result) {
			
			System.out.println("Price Updated Successfully");
		}
		else {
			System.out.println("Product is not found");
		}
	}
   
	//update the quantity
	@Override
	public void updateProductQuantity(int productId, int quantity) {
		
		Boolean result = productRepository.updateProductQuantity(productId,quantity);
		if(result) {
			
			System.out.println("Quantity Updated Successfully");
		}
		else {
			System.out.println("Product is not found");
		}
	}
	//delete the product
	
	@Override
	public void deleteProduct(int productId) {

	    Boolean result = productRepository.deleteProduct(productId);

	    if (result) {

	        System.out.println("Product Deleted Successfully");

	    } else {

	        System.out.println("Product is not found");
	    }
	}
	
	}


