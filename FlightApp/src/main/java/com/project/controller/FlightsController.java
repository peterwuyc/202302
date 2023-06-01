package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.model.Seats;
import com.project.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.CategoryEnum;
import com.project.model.Flights;
import com.project.model.FlightsDTO;
import com.project.service.FlightsService;

@RestController
public class FlightsController {
	@Autowired
	private FlightsService ppService;

	@Autowired
	private SeatsService seatService;

	@GetMapping("/{flightId}/seats")
	public ResponseEntity<List<Seats>> getAvailableSeatsForFlight(@PathVariable Integer flightId) {
		List<Seats> availableSeats = seatService.getAvailableSeatsForFlight(ppService.getFlightById(flightId));
		return ResponseEntity.ok(availableSeats);
	}
	
	
	@PostMapping("/addnewproducts")
	public Flights saveProductsHandler(@Valid @RequestBody Flights product) {
		
		return ppService.addProducts(product);
	}
	
	@GetMapping("/allproducts")
	public List<Flights> getAllProducts(){
		
		return ppService.getAllProducts();
	}

	@GetMapping("/userProducts")
	public List<FlightsDTO> getUserProducts(){

		return ppService.getUserProducts();
	}

	@GetMapping("/userProducts/{id}")
	public List<FlightsDTO> getUserProductsById(@PathVariable("id") Integer id){

		return ppService.getUserProductsById(id);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Flights> getProductFromCatalogByIdHandler(@PathVariable("id") Integer id) {
		
		Flights prod =  ppService.getProductsFromCatalogById(id);

		return new ResponseEntity<Flights>(prod, HttpStatus.FOUND);

	}

	@GetMapping("/products/{cat}")
	public List<FlightsDTO> getCategoryWiseProducts(@PathVariable("cat") CategoryEnum cat) {
	
		return ppService.getCategoryWiseProducts(cat);
		
	}

	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProductFromCatalogHandler(@PathVariable("id") Integer id) {
		
		String res = ppService.deleteProductFromCatalog(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	

	@PutMapping("/updateproducts")
	public ResponseEntity<Flights> updateProductInCatalogHandler(@Valid @RequestBody Flights prod) {

		Flights prod1 = ppService.updateProductIncatalog(prod);

		return new ResponseEntity<Flights>(prod1, HttpStatus.OK);

	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/products/{id}")
//	public Products getProductsById(@PathVariable("id") Integer id) {
//		
//		return ppService.getProductFromCatalogById(id);
//	}
//	
//	/////////////////////////////////////////////////////////////////////
//	
//	@GetMapping("/test/{id}")
//	public Products getproductsById(@PathVariable("id") Integer id) {
//		
//		return ppService.getproductsById(id);
//	}
//	
//	///////////////////////////////////////////////////////
//	
//	@GetMapping("/category/{cat}")
//	public List<ProductsDTO> getfunctions(@PathVariable("cat") CategoryEnum cat) {
//		
//		return ppService.funCategory(cat);
//	}
//	
//	/////////////////////////////////////////////////////////////
//	@PostMapping("/addcategorywise/{cat}")
//	public Products addProductsByCategory(@RequestBody @PathVariable("cat") CategoryEnum cat, Products products) {
//		
//		return ppService.addProductsByCategory(cat, products);
//		
//	}
	
