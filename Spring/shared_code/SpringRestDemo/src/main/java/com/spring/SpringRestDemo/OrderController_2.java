package com.spring.SpringRestDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("iter") //http://localhost:8080/iter
public class OrderController_2 {

	
	@PostMapping(value="/order", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Order createNewOrder(@RequestBody Order order) {
		orderList.add(order);
		return order;
	}
	
	@PutMapping(value="/order/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Order updateOrder(@RequestBody Order order, @PathVariable(name="id") String orderId) {
		Order originalOrder = getOrderById(orderId);
		originalOrder.setPrice(order.getPrice());
		originalOrder.setTitle(order.getTitle());
		return originalOrder;
	}
	
	@DeleteMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteOrderById(@PathVariable(name="id") String orderId, @RequestHeader(name="auth-token") String authToken) {
		
		if(authToken==null) {
			return "{\"result\": \"Auth-token is mandatory\"}";
		}
		else if(authToken.equals("T45L")) {
			Order originalOrder = getOrderById(orderId);
			if(orderList.contains(originalOrder)) {
				orderList.remove(originalOrder);
				return "{\"result\": \"Order deleted\"}";
			}
			else {
				return "{\"result\": \"Order id is invalid\"}";
			}
		}
		else {
			return "{\"result\": \"Invalid user\"}";
		}
	}
	
/*	
	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		return orderList;
	}
*/
	
	//localhost:8080/iter/order?id=3	[Query Parameter]	
	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderById(@RequestParam(name="id") String orderId) {
		Predicate<Order> predicate = (Order order)->order.getId()==Integer.parseInt(orderId);
		List<Order> matchingOrders = orderList.stream().filter(predicate).collect(Collectors.toList());
		return matchingOrders.get(0);
	}


//organization/{orgId}/employee/{empId}		[Recommended]
//organization/employee?orgId=5&empId=25		[Not Recommended]
	
	//localhost:8080/iter/order/3	[Template Parameter]	
	@GetMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderByIdUsingTemplate(@PathVariable(name="id") String orderId) {
		List<Order> matchingOrders = orderList.stream().filter((Order order)->order.getId()==Integer.parseInt(orderId)).collect(Collectors.toList());
		return matchingOrders.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private static List<Order> orderList = new ArrayList<Order>();
	static {
		orderList.add(new Order(1, "Chairs", 15000));
		orderList.add(new Order(2, "Tables", 66000));
		orderList.add(new Order(3, "Fans", 80000));
	}
}
