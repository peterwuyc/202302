package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.MyOrder;
import com.project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderservice;

	
	@PostMapping("/addFromCart/{userId}")
	public ResponseEntity<MyOrder>addOrderFromCart(@PathVariable Integer userId){
		MyOrder myOrder=orderservice.addorderFromCart(userId);
		return new ResponseEntity<MyOrder>(myOrder,HttpStatus.ACCEPTED);
	}

	@PostMapping("/cancelOrder/{orderId}")
	public ResponseEntity<MyOrder> cancelOrder(@PathVariable Integer orderId){
		MyOrder myOrder=orderservice.cancelOrder(orderId);
		return new ResponseEntity<MyOrder>(myOrder,HttpStatus.ACCEPTED);
	}

	@PostMapping("/completeOrder/{orderId}")
	public ResponseEntity<MyOrder> completeOrder(@PathVariable Integer orderId){
		MyOrder myOrder=orderservice.completeOrder(orderId);
		return new ResponseEntity<MyOrder>(myOrder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findallOrder")
	public ResponseEntity<List<MyOrder>>viewAllOrder(){
		List<MyOrder>allOrder= orderservice.viewOrder();
		return new ResponseEntity<List<MyOrder>>(allOrder,HttpStatus.ACCEPTED);
	}

	@GetMapping("/findByCustomerId/{customerId}")
	public ResponseEntity<MyOrder>viewOrderByCustomerID(@PathVariable Integer customerId){
		MyOrder findOrder=orderservice.viewOrderByCustomerId(customerId);
		return new ResponseEntity<MyOrder>(findOrder,HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/findOrderByUserName/{FirstName}/{LastName}/{mobileNo}")
//	public ResponseEntity<List<MyOrder>>viewByUserName(@PathVariable("FirstName") String FirstName,@PathVariable("LastName") String LastName,@PathVariable("mobileNo") String mobileNo ){
//		List<MyOrder>getOrderByName= orderservice.findOrderByUserName(FirstName, LastName,mobileNo);
//		return new ResponseEntity<List<MyOrder>>(getOrderByName,HttpStatus.ACCEPTED);
//	}
	
	@DeleteMapping("removeOrder/{customerId}")
	public ResponseEntity<String>removeOrderByCustomerID(@PathVariable Integer customerId){
		String findOrder=orderservice.removeOrder(customerId);
		
		return new ResponseEntity<String>(findOrder,HttpStatus.ACCEPTED);
	}
}
