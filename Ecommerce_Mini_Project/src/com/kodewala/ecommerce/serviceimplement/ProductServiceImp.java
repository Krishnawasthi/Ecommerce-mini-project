package com.kodewala.ecommerce.serviceimplement;

import java.util.List;

import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.ProductService;

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
			
			System.out.println("Product is not found");
		}
				
		
	}

	@Override
	public void searchProductbyName(String productName) {
		
		productRepository
	}

	@Override
	public void searchProductbyCategory(String category) {
		productRepository
		
	}

	@Override
	public void updateProductPrice(int productId, double price) {
		
		productRepository
	}

	@Override
	public void updateProductQuantity(int productId, int quantity) {
		
		productRepository
	}

}
