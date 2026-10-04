package com.kodewala.ecommerce.serviceimplement;

import java.util.List;

import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.model.Order;
import com.kodewala.ecommerce.model.OrderStatus;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.CartRepository;
import com.kodewala.ecommerce.repository.CustomerRepository;
import com.kodewala.ecommerce.repository.OrderRepository;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.OrderService;

public class OrderServiceImp implements OrderService {

	
	// accessing cart repo and product repo
	private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

	public OrderServiceImp(CustomerRepository customerRepository, CartRepository cartRepository,
			ProductRepository productRepository, OrderRepository orderRepository) {
		super();
		this.customerRepository = customerRepository;
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}
//placing order or by finding customer using customer id
	@Override
	public void placeOrder(int customerId) {
		//finding customer by Id
		Customer customer  = customerRepository.findCostomerById(customerId);
		//if customer not found
		if(customer == null) {
			
			System.out.println("customer not found");
			return;
		}
		
		//getting customer cart
		List<CartItem> cart = cartRepository.getCart(customerId);
		
		//empty cart
		if(cart.isEmpty()) {
			
			System.out.println("no items in customer's cart");
			return;
		}
		
		 //checking stock
		for(CartItem item : cart) {
			Product product = item.getProduct();
			
			if(item.getQuantity() > product.getQuantity() ) {
				
				System.out.println("insufficient stock for this product");
				return;
			}
			
			
		}
	

	//generatig unique id 
	int orderId = getUniqueOrderId();
	
	//creating order Object
	Order order = new Order(orderId, customerId, cart);
	
	//adding order into order repository
	orderRepository.addOrder(order);
	
	//reducing product quantity
	for(CartItem item : cart) {
		
		Product product = item.getProduct();
		product.setQuantity(product.getQuantity() - (int) item.getQuantity());
		
	}
	
	//clearing custoemer cart
	clearingCart(customerId);
	System.out.println("Order Placed SuccessFully");
	System.out.println(order);
	
	}
	
	
	//generating unique logic for orderId
	@Override
	public int getUniqueOrderId() {
		int orderId = 100001;
		//if you dont find the same order by its order it simply increase the orderId by one so it will give you unique orderId for everytime you will place order
		while(orderRepository.findOrderById(orderId) != null) {
			
			orderId++;
		}
		return orderId;
		
	}
  
	//clearing customer cart
	@Override
	public void clearingCart(int customerId) {
		
		cartRepository.clearCart(customerId);
		System.out.println("Cart cleared successfully");
		
	}

	//view all order of a customers
	@Override
	public void viewOrder(int customerId) {
		
		List<Order> customerOrder = orderRepository.findOrdersByCustomerId(customerId);
		if(customerOrder.isEmpty()) {
			
			System.out.println("no orders found");
			return;
		}
		for(Order order: customerOrder) {
			
			
			System.out.println(order);
		}
	}

	//view all orders 
	@Override
	public void viewAllOrders() {
		List<Order> orders = orderRepository.getAllOrder();
		if(orders.isEmpty()) {
			
			System.out.println("no orders availble");
			return;
		}
for(Order order: orders) {
			
			
			System.out.println(order);
		}
	}

	//cancelling order
	@Override
	public void cancelOrder(int customerId, int orderId) {
		//finding order by order id
		
	Order order = orderRepository.findOrderById(orderId);
	
	//edge case1: if any order is not there 
	if(order == null) {
		
		System.out.println("order not found");
		return;
	}
	
	//if wrong customer Id 
	if(order.getCustomerId() != customerId) {
		System.out.println("this order does not belong to this customer");
		return;
	}
	//checking whether order already cancel
	if(order.getOrderStatus() == OrderStatus.CANCELLED) {
		
		System.out.println("Order is already cancelled");
		return;
		
	}
	
	//now cancelling order if not by setting it cancel status
	order.setOrderStatus(OrderStatus.CANCELLED);
	System.out.println("Ordr cancelled successfully");
			
			
		
			
	
		
	}

}
