package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Cart;
import com.project.repository.CartDao;
import com.project.service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired 
	private CartDao cDao;

	//To add the data we use this 
	
	@PostMapping("/addtocart/{id}/{custId}/{seatId}")
	public ResponseEntity<Cart>addorder(@RequestBody Cart cart,@PathVariable Integer id,@PathVariable Integer custId,@PathVariable Integer seatId){

		Cart uporder= cartService.AddProduct(cart, id, custId,seatId);
		return new ResponseEntity<Cart>(uporder,HttpStatus.ACCEPTED);
	}
	
	//To delete the cart data
	
	@DeleteMapping(value = "/cart/{id}")
	public ResponseEntity<String> removeCartProduct(@PathVariable("id") Integer id){
		
		String res = cartService.deleteProductfromCart(id);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	//To view the cart data;
	
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllProductsHandler() {

		List<Cart> list = cartService.ViewAllCart();

		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}
	
	//To update the cart data
	
//	@PutMapping("/carts")
//	public ResponseEntity<Cart> updateProductInCatalogHandler(@RequestBody Cart cart) {
//
//		Cart cart1=cartService.UpdateCartProduct(cart);
//
//		return new ResponseEntity<Cart>(cart1, HttpStatus.OK);
//
//	}
//	
	@DeleteMapping(value = "/cart/clear")
	public String clearCartHandler(){
		cartService.deleteAllCart();
		String res="Cart is empty Now";
		return res;
		
	}
//

	@PutMapping("/{orderId}/seat/{newSeatId}")
	public ResponseEntity<String> changeSeatInOrder(@PathVariable Integer orderId, @PathVariable Integer newSeatId) {
		try {
			cartService.changeSeatInOrder(orderId, newSeatId);
			return ResponseEntity.ok("Seat in the order has been updated successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the seat in the order.");
		}
	}
	
}
