package com.kodewala.ecommerce.main;

import java.util.Scanner;

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

		Scanner sc = new Scanner(System.in);
		// -------------------------------------------------------------------------------------------------------
		System.out.println("MAIN STARTED");
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

		// Main menu
		while (true) {

			System.out.println("----------------------------------------------");
			System.out.println("E-commerce System");
			System.out.println("----------------------------------------------");
			System.out.println("1-Admin");
			System.out.println("2-Customer");
			System.out.println("3-Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			System.out.println("--------------------Admin------------------");
			if (choice == 1) {

				System.out.println("Admin Selected");

				while (true) {

					System.out.println();
					System.out.println("----------------------------------------------");
					System.out.println("-------------------------- ADMIN MENU--------------------------");
					System.out.println("----------------------------------------------");
					System.out.println("1- Add Product");
					System.out.println("2- View Products");
					System.out.println("3- Search Product");
					System.out.println("4- Update Product");
					System.out.println("5- Delete Product");
					System.out.println("6- View Customers");
					System.out.println("7- View All Orders");
					System.out.println("8- Exit");

					System.out.print("Enter your choice: ");
					int adminChoice = sc.nextInt();

					// add product
					if (adminChoice == 1) {

						System.out.print("Enter product Id: ");
						int productId = sc.nextInt();

						System.out.print("Enter Product Name: ");
						String productName = sc.next();

						System.out.print("Enter Category: ");
						String category = sc.next();

						System.out.print("Enter Price: ");
						double price = sc.nextDouble();

						System.out.print("Enter Quantity: ");
						int quantity = sc.nextInt();

						System.out.print("Enter Brand: ");
						String brand = sc.next();

						Product product = new Product(productId, productName, category, price, quantity, brand);

						productService.addProduct(product);
					}

					// view product
					else if (adminChoice == 2) {

						productService.viewAllProduct();

					}

					// seach product
					else if (adminChoice == 3) {

						System.out.println("1- Search By Product Id");
						System.out.println("2- Search By Product Name");
						System.out.println("3- Search By Category");

						System.out.print("Enter your choice: ");
						int searchChoice = sc.nextInt();

						if (searchChoice == 1) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							productService.searchProductbyId(productId);

						} else if (searchChoice == 2) {

							System.out.print("Enter Product Name: ");
							String productName = sc.next();

							productService.searchProductbyName(productName);

						} else if (searchChoice == 3) {

							System.out.print("Enter Category: ");
							String category = sc.next();

							productService.searchProductbyCategory(category);

						} else {

							System.out.println("Invalid search choice");
						}

					} else if (adminChoice == 4) {

						System.out.println("1- Update Product Price");
						System.out.println("2- Update Product Quantity");

						System.out.print("Enter your choice: ");
						int updateChoice = sc.nextInt();

						if (updateChoice == 1) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							System.out.print("Enter New Price: ");
							double price = sc.nextDouble();

							productService.updateProductPrice(productId, price);

						} else if (updateChoice == 2) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							System.out.print("Enter New Quantity: ");
							int quantity = sc.nextInt();

							productService.updateProductQuantity(productId, quantity);

						} else {

							System.out.println("Invalid choice");
						}

					} else if (adminChoice == 5) {

					

						    System.out.print("Enter Product Id: ");
						    int productId = sc.nextInt();

						    productService.deleteProduct(productId);

						}

					 else if (adminChoice == 6) {

						 customerService.viewAllCustomer();

					} else if (adminChoice == 7) {

						 orderService.viewAllOrders();

					} else if (adminChoice == 8) {

						System.out.println("Exiting Admin Menu");
						break;

					} else {

						System.out.println("Invalid choice");
					}
					      
				}
			 else if (choice == 2) {

				System.out.println("Customer Selected");

				System.out.println();
				System.out.println("----------------------------------------------");
				System.out.println("       CUSTOMER MENU");
				System.out.println("----------------------------------------------");
				System.out.println("1- Register");
				System.out.println("2- Login");
				System.out.println("3- View Products");
				System.out.println("4- Search Product");
				System.out.println("5- Add Product to Cart");
				System.out.println("6- View Cart");
				System.out.println("7- Remove Product from Cart");
				System.out.println("8- Place Order");
				System.out.println("9- View My Orders");
				System.out.println("10- Cancel Order");
				System.out.println("11- Logout");

				System.out.print("Enter your choice: ");

				int customerChoice = sc.nextInt();

				if (customerChoice == 1) {

            

				} else if (customerChoice == 2) {

					System.out.println("Login selected");

				} else if (customerChoice == 3) {

					System.out.println("View Products selected");

				} else if (customerChoice == 4) {

					System.out.println("Search Product selected");

				} else if (customerChoice == 5) {

					System.out.println("Add Product to Cart selected");

				} else if (customerChoice == 6) {

					System.out.println("View Cart selected");

				} else if (customerChoice == 7) {

					System.out.println("Remove Product from Cart selected");

				} else if (customerChoice == 8) {

					System.out.println("Place Order selected");

				} else if (customerChoice == 9) {

					System.out.println("View My Orders selected");

				} else if (customerChoice == 10) {

					System.out.println("Cancel Order selected");

				} else if (customerChoice == 11) {

					System.out.println("Logout");
					break;

				} else {

					System.out.println("Invalid choice");
				}

			 }

			else if (choice == 3) {

				System.out.println("Application Exit");
			} else {

				System.out.println("Invalid choice");
			}

			sc.close();
		}

		// creating products
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

		// view cart
		System.out.println("--------------------- CUSTOMER CART---------------------");

		cartService.viewCart(101);

		// Total Cart Value
		// ----------------------------------------------------

		System.out.println("-----------------------------CART TOTAL-----------------------------");

		cartService.totalCartValue(101);

		// Increase Quantity

		System.out.println("--------------- INCREASE QUANTITY---------------");

		cartService.increaseQuantity(101, 101);

		cartService.viewCart(101);

		// Decrease Quantity

		System.out.println("-------------- DECREASE QUANTITY--------------");

		cartService.decreaseQuantity(101, 101);

		cartService.viewCart(101);

		// Place Order

		System.out.println("-------------- PLACE ORDER--------------");

		orderService.placeOrder(101);

		// View Customer Orders

		System.out.println("-------------- CUSTOMER ORDERS-------------- ");

		orderService.viewOrder(101);

		// View All Orders

		System.out.println("----------------------ALL ORDERS----------------------");

		orderService.viewAllOrders();

		// 17. Check Product Stock After Order
		// ----------------------------------------------------

		System.out.println("--------------------PRODUCTS AFTER ORDER--------------------");

		productService.viewAllProduct();

	}

}
		