package com.kodewala.ecommerce.main;

import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.CartRepository;
import com.kodewala.ecommerce.repository.CustomerRepository;
import com.kodewala.ecommerce.repository.OrderRepository;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.CartService;
import com.kodewala.ecommerce.service.CustomerService;
import com.kodewala.ecommerce.service.OrderService;
import com.kodewala.ecommerce.service.ProductService;
import com.kodewala.ecommerce.serviceimplement.CartSeriveImp;
import com.kodewala.ecommerce.serviceimplement.CustomerServiceImp;
import com.kodewala.ecommerce.serviceimplement.OrderServiceImp;
import com.kodewala.ecommerce.serviceimplement.ProductServiceImp;

public class EcommerceApplication {

	public static void main(String[] args) {

		// creating repository object
		ProductRepository productRepository = new ProductRepository();

		CustomerRepository customerRepository = new CustomerRepository();

		CartRepository cartRepository = new CartRepository();

		OrderRepository orderRepository = new OrderRepository();

		// creating service object

		ProductService productService = new ProductServiceImp(productRepository);
		CustomerService customerService = new CustomerServiceImp(customerRepository);
		CartService cartService = new CartSeriveImp(cartRepository, productRepository);
		OrderService orderService = new OrderServiceImp(customerRepository, cartRepository, orderRepository);

		// creatig products
		Product product1 = new Product(101, "iPhone 17", "Mobile", 120000, 10, "Apple");

		Product product2 = new Product(102, "Dell Laptop", "Laptop", 70000, 5, "Dell");

		Product product3 = new Product(103, "Wireless Mouse", "Accessories", 1500, 20, "Logitech");

		// adding product

		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);

		// view all products

		System.out.println("--------All Products");
		productService.viewAllProduct();

		// Creating Customers
		Customer customer1 = new Customer(101, "Krishna", "krishna@gmail.com", "803533429", "BTM Layout");

		Customer customer2 = new Customer(102, "Rahul", "rahul@gmail.com", "9876543210", "Whitefield");
		
		 // Registering Customers
		customerService.registerCustomer(customer1);
		customerService.registerCustomer(customer2);
		
		 // Viewing Customer
      
        System.out.println("-------CUSTOMER DETAILS-----------");

        customerService.searchById(101);

        // Adding Product to Customer Cart
       

        System.out.println("---------------------ADDING PRODUCTS TO CART-------------------");

        cartService.addToCart(101, 101, 2);

        cartService.addToCart(101, 103, 3);
        
        
       //view cart 
        System.out.println("--------------------- CUSTOMER CART---------------------");

        cartService.viewCart(101);
        
        
        //Total Cart Value
        // ----------------------------------------------------

        System.out.println("-----------------------------CART TOTAL-----------------------------");

        cartService.totalCartValue(101);
        
        
     //Increase Quantity
       

        System.out.println("--------------- INCREASE QUANTITY---------------");

        cartService.increaseQuantity(101, 101);

        cartService.viewCart(101);
        
     //Decrease Quantity
      

        System.out.println("-------------- DECREASE QUANTITY--------------");

        cartService.decreaseQuantity(101, 101);

        cartService.viewCart(101);
        
     // Place Order
       

        System.out.println("-------------- PLACE ORDER--------------");

        orderService.placeOrder(101);

     // View Customer Orders
        

        System.out.println("-------------- CUSTOMER ORDERS-------------- ");

        orderService.viewOrder(101);
        
        //View All Orders
       

        System.out.println("----------------------ALL ORDERS----------------------");

        orderService.viewAllOrders();
        
        
        // 17. Check Product Stock After Order
        // ----------------------------------------------------

        System.out.println("--------------------PRODUCTS AFTER ORDER--------------------");

        productService.viewAllProduct();


	}

}