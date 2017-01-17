package com.bharath.trainings.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.lance.services.customerorders.AllOrdersRequest;
import com.lance.services.customerorders.AllOrdersResponse;
import com.lance.services.customerorders.CreateOrdersRequest;
import com.lance.services.customerorders.CreateOrdersResponse;
import com.lance.services.customerorders.CustomerOrdersPortType;
import com.lance.services.customerorders.CustomerOrdersService;
import com.lance.services.customerorders.GetOrdersRequest;
import com.lance.services.customerorders.GetOrdersResponse;
import com.lance.services.customerorders.Order;
import com.lance.services.customerorders.Product;

public class CustomerOrdersWSClient {

	public static void main(String[] args) {
		try {
			BigInteger customerId = BigInteger.valueOf(1);
			
			//setup service / port
			CustomerOrdersService service = new CustomerOrdersService(new URL(
					"http://localhost:8888/wsdlfirst/services/CustomerOrders?wsdl"));			
			CustomerOrdersPortType port = service.getCustomerOrdersPort();
			
			//add orders
			CreateOrdersResponse createOrdersResponse = addOrderByCustomerId(customerId, port);
			System.out.println(createOrdersResponse.isResult() ? "Success" : "Failed");
			
			//retrieve orders
//			List<Order> orders = getOrdersByCustomerId(customerId, port);
			
			List<Order> orders = getAllOrders(port);
			for (Order order : orders) {
				List<Product> products = order.getProduct();
				for (Product product : products) {
					System.out.println("Product Description " + product.getDescription());
					System.out.println("Product Quantity  " + product.getQuantity());
				}
			}

		} catch (MalformedURLException  e) {
			e.printStackTrace();
		}
	}

	private static List<Order> getAllOrders(CustomerOrdersPortType port) {
		AllOrdersRequest request = new AllOrdersRequest();
		AllOrdersResponse response = port.allOrders(request);
		return response.getOrder();
	}
	
	private static List<Order> getOrdersByCustomerId(BigInteger id, CustomerOrdersPortType port) {
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(id);
		GetOrdersResponse response = port.getOrders(request);

		return response.getOrder();
	}

	private static CreateOrdersResponse addOrderByCustomerId(BigInteger id, CustomerOrdersPortType port) {
		CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
		createOrdersRequest.setCustomerId(id);
		
		Product charger = new Product();
		charger.setId(String.valueOf(new Date().getTime()));
		charger.setDescription("USB Charger");
		charger.setQuantity(BigInteger.valueOf(new Date().getTime() % 4));
		
		Product laptop = new Product();
		laptop.setId("6534a32");
		laptop.setDescription("Macbook Pro");
		laptop.setQuantity(BigInteger.valueOf(new Date().getTime() % 4));
		
		Collection<? extends Product> products = Arrays.asList(charger, laptop);
		
		Order order = new Order();
		order.setId(BigInteger.valueOf(new Date().getTime()));
		order.getProduct().addAll(products);
		createOrdersRequest.setOrder(order);
		return port.createOrders(createOrdersRequest );
	}
}
