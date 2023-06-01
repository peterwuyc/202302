package com.project.service;

import java.util.List;

import com.project.model.CategoryEnum;
import com.project.model.Flights;
import com.project.model.FlightsDTO;

public interface FlightsService {

	public Flights addProducts(Flights flights);
	
	public List<Flights> getAllProducts();
	
	public Flights getProductsFromCatalogById(Integer id);
	
	public List<FlightsDTO> getCategoryWiseProducts(CategoryEnum cat);
	
	public String deleteProductFromCatalog(Integer id);
	
	public Flights updateProductIncatalog(Flights product);

    List<FlightsDTO> getUserProducts();

	List<FlightsDTO> getUserProductsById(Integer id);

	public Flights getFlightById(Integer flightId);

}
	
	
	
	
	
	
	
	
	
	
	
	