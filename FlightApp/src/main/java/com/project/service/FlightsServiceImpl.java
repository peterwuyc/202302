package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.exception.ProductNotFoundException;
import com.project.model.CategoryEnum;
import com.project.model.Flights;
import com.project.model.FlightsDTO;
import com.project.repository.FlightsDao;

@Service
public class FlightsServiceImpl implements FlightsService {


	@Autowired
	private FlightsDao psDao;
	
	@Override
	public Flights addProducts(Flights flights) {
		// TODO Auto-generated method stub
		
		return psDao.save(flights);
		
	}

	@Override
	public List<Flights> getAllProducts() {
		// TODO Auto-generated method stub
		List<Flights> list = psDao.findAll();
		
		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products in catalog");
	}

	@Override
	public Flights getProductsFromCatalogById(Integer id) {
		Optional<Flights> opt = psDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}

		else
			throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public List<FlightsDTO> getCategoryWiseProducts(CategoryEnum cat) {
		
		List<FlightsDTO> result= psDao.getCategoryWiseProducts(cat);
		
		return result;
	}

	@Override
	public String deleteProductFromCatalog(Integer id) throws ProductNotFoundException {
		
		Optional<Flights> opt=	psDao.findById(id);
			
		if(opt.isPresent()) {
				Flights prod = opt.get();
				psDao.delete(prod);
				return "Product deleted from catalog";
			} else
				throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public Flights updateProductIncatalog(Flights product) throws ProductNotFoundException {

		Optional<Flights> opt = psDao.findById(product.getProductId());

		if (opt.isPresent()) {
			opt.get();
			Flights prod1 = psDao.save(product);
			return prod1;
		} else
			throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public List<FlightsDTO> getUserProducts() {
		List<FlightsDTO> list = psDao.findUserProducts();

		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products in catalog");
	}

	@Override
	public List<FlightsDTO> getUserProductsById(Integer id) {
		List<FlightsDTO> list = psDao.findUserProductsById(id);

		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products in catalog");
	}

	public Flights getFlightById(Integer flightId) {
		Optional<Flights> optionalFlight = psDao.findById(flightId);
		return optionalFlight.orElse(null); // Return null if flight not found
	}


}