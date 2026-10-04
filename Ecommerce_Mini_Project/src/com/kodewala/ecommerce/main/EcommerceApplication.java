package com.kodewala.ecommerce.main;

import java.util.Scanner;

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
import com.kodewala.ecommerce.exception.ProductNotFoundException;
import com.kodewala.ecommerce.exception.InsufficientStockException;
import com.kodewala.ecommerce.exception.CustomerNotFoundException;

public class EcommerceApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		// CREATING REPOSITORY OBJECTS
	
		ProductRepository productRepository = new ProductRepository();

		CustomerRepository customerRepository = new CustomerRepository();

		CartRepository cartRepository = new CartRepository();

		OrderRepository orderRepository = new OrderRepository();

		
		// CREATING SERVICE OBJECTS
	

		ProductService productService = new ProductServiceImp(productRepository);

		CustomerService customerService = new CustomerServiceImp(customerRepository);

		CartService cartService = new CartSeriveImp(
				cartRepository,
				productRepository);

		OrderService orderService = new OrderServiceImp(
				customerRepository,
				cartRepository,
				orderRepository);

	
		// MAIN MENU
		

		while (true) {

			System.out.println();
			System.out.println("----------------------------------------------");
			System.out.println("             E-COMMERCE SYSTEM");
			System.out.println("----------------------------------------------");
			System.out.println("1- Admin");
			System.out.println("2- Customer");
			System.out.println("3- Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			// ADMIN
			
			if (choice == 1) {

				System.out.println();
				System.out.println("Admin Selected");

				while (true) {

					System.out.println();
					System.out.println("----------------------------------------------");
					System.out.println("                  ADMIN MENU");
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

					
					// 1. ADD PRODUCT
				

					if (adminChoice == 1) {

						System.out.print("Enter Product Id: ");
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

						Product product = new Product(
								productId,
								productName,
								category,
								price,
								quantity,
								brand);

						productService.addProduct(product);
					}

					// 2. VIEW PRODUCTS
				

					else if (adminChoice == 2) {

						productService.viewAllProduct();
					}

					
					// 3. SEARCH PRODUCT
					

					else if (adminChoice == 3) {

						System.out.println();
						System.out.println("1- Search By Product Id");
						System.out.println("2- Search By Product Name");
						System.out.println("3- Search By Category");

						System.out.print("Enter your choice: ");
						int searchChoice = sc.nextInt();

						if (searchChoice == 1) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							try {

								productService.searchProductbyId(productId);

							} catch (ProductNotFoundException e) {

								System.out.println(e.getMessage());
							}

						}

						else if (searchChoice == 2) {

							System.out.print("Enter Product Name: ");
							String productName = sc.next();

							productService.searchProductbyName(productName);

						}

						else if (searchChoice == 3) {

							System.out.print("Enter Category: ");
							String category = sc.next();

							productService.searchProductbyCategory(category);

						}

						else {

							System.out.println("Invalid search choice");
						}
					}

				
					// 4. UPDATE PRODUCT
					

					else if (adminChoice == 4) {

						System.out.println();
						System.out.println("1- Update Product Price");
						System.out.println("2- Update Product Quantity");

						System.out.print("Enter your choice: ");
						int updateChoice = sc.nextInt();

						if (updateChoice == 1) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							System.out.print("Enter New Price: ");
							double price = sc.nextDouble();

							productService.updateProductPrice(
									productId,
									price);

						}

						else if (updateChoice == 2) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							System.out.print("Enter New Quantity: ");
							int quantity = sc.nextInt();

							productService.updateProductQuantity(
									productId,
									quantity);

						}

						else {

							System.out.println("Invalid choice");
						}
					}

					
					// 5. DELETE PRODUCT
					

					else if (adminChoice == 5) {

						System.out.print("Enter Product Id: ");
						int productId = sc.nextInt();

						productService.deleteProduct(productId);
					}

					
					// 6. VIEW CUSTOMERS
				

					else if (adminChoice == 6) {

						customerService.viewAllCustomer();
					}

					
					// 7. VIEW ALL ORDERS
					

					else if (adminChoice == 7) {

						orderService.viewAllOrders();
					}

					
					// 8. EXIT ADMIN
					
					else if (adminChoice == 8) {

						System.out.println("Exiting Admin Menu");
						break;
					}

					else {

						System.out.println("Invalid choice");
					}
				}
			}

			
			// CUSTOMER
			

			else if (choice == 2) {

				System.out.println();
				System.out.println("Customer Selected");

				// -1 means no customer is currently logged in
				int loggedInCustomerId = -1;

				while (true) {

					System.out.println();
					System.out.println("----------------------------------------------");
					System.out.println("                CUSTOMER MENU");
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

					
					// 1. REGISTER
					

					if (customerChoice == 1) {

						System.out.print("Enter Customer Id: ");
						int customerId = sc.nextInt();

						System.out.print("Enter Customer Name: ");
						String customerName = sc.next();

						System.out.print("Enter Email: ");
						String email = sc.next();

						System.out.print("Enter Mobile: ");
						String mobile = sc.next();

						System.out.print("Enter Address: ");
						String address = sc.next();

						Customer customer = new Customer(
								customerId,
								customerName,
								email,
								mobile,
								address);

						customerService.registerCustomer(customer);
					}

					
					// 2. LOGIN
					
					else if (customerChoice == 2) {

						System.out.print("Enter Customer Id: ");
						int customerId = sc.nextInt();

						Customer customer =
								customerRepository.findCostomerById(customerId);

						if (customer != null) {

							loggedInCustomerId = customerId;

							System.out.println("Login Successful");
							System.out.println(
									"Welcome " + customer.getCustomerName());

						}

						else {

							System.out.println("Customer not found");
						}
					}

				
					// 3. VIEW PRODUCTS
					
					else if (customerChoice == 3) {

						productService.viewAllProduct();
					}

					// 4. SEARCH PRODUCT
					

					else if (customerChoice == 4) {

						System.out.println();
						System.out.println("1- Search By Product Id");
						System.out.println("2- Search By Product Name");
						System.out.println("3- Search By Category");

						System.out.print("Enter your choice: ");
						int searchChoice = sc.nextInt();

						if (searchChoice == 1) {

							System.out.print("Enter Product Id: ");
							int productId = sc.nextInt();

							productService.searchProductbyId(productId);

						}

						else if (searchChoice == 2) {

							System.out.print("Enter Product Name: ");
							String productName = sc.next();

							productService.searchProductbyName(productName);

						}

						else if (searchChoice == 3) {

							System.out.print("Enter Category: ");
							String category = sc.next();

							productService.searchProductbyCategory(category);

						}

						else {

							System.out.println("Invalid search choice");
						}
					}

				
					// 5. ADD PRODUCT TO CART
				
					else if (customerChoice == 5) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						System.out.print("Enter Product Id: ");
						int productId = sc.nextInt();

						System.out.print("Enter Quantity: ");
						int quantity = sc.nextInt();

						cartService.addToCart(
								loggedInCustomerId,
								productId,
								quantity);
					}

					
					// 6. VIEW CART
					

					else if (customerChoice == 6) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						cartService.viewCart(loggedInCustomerId);

						cartService.totalCartValue(
								loggedInCustomerId);
					}

					
					// 7. REMOVE PRODUCT FROM CART
					

					else if (customerChoice == 7) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						System.out.print("Enter Product Id: ");
						int productId = sc.nextInt();

						cartService.removeFromCart(
								loggedInCustomerId,
								productId);
					}

				
					// 8. PLACE ORDER
					
					else if (customerChoice == 8) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						orderService.placeOrder(
								loggedInCustomerId);
					}

					
					// 9. VIEW MY ORDERS
					

					else if (customerChoice == 9) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						orderService.viewOrder(
								loggedInCustomerId);
					}

					
					// 10. CANCEL ORDER
					

					else if (customerChoice == 10) {

						if (loggedInCustomerId == -1) {

							System.out.println("Please login first");
							continue;
						}

						System.out.print("Enter Order Id: ");
						int orderId = sc.nextInt();

						orderService.cancelOrder(
								loggedInCustomerId,
								orderId);
					}

					
					// 11. LOGOUT
					

					else if (customerChoice == 11) {

						if (loggedInCustomerId != -1) {

							loggedInCustomerId = -1;

							System.out.println("Logout Successful");
						}

						else {

							System.out.println("You are not logged in");
						}

						break;
					}

					else {

						System.out.println("Invalid choice");
					}
				}
			}

			
			// EXIT APPLICATION
			

			else if (choice == 3) {

				System.out.println("Application Exit");
				break;
			}

			else {

				System.out.println("Invalid choice");
			}
		}

		sc.close();
	}
}