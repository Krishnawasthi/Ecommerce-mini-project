package com.kodewala.ecommerce.service;

import com.kodewala.ecommerce.model.Product;

public interface ProductService {
    void addProduct(Product product);
    void viewAllProduct();
    void searchProductbyId(int productId);
    void searchProductbyName(String productName);
    void searchProductbyCategory(String category);
    void updateProductPrice(int productId, double price);
    void updateProductQuantity(int productId, int quantity);
}
