package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.CategoryEnum;
import com.project.model.Flights;
import com.project.model.FlightsDTO;


@Repository
public interface FlightsDao extends JpaRepository<Flights, Integer> {
	
	public List<Flights>  findByName(String name);

	Optional<Flights> findById(Integer id);
	
	@Query("select new com.project.model.FlightsDTO(p.name, p.retailPrice,p.description) from Flights p ")
	public List<FlightsDTO> getCategoryWiseProducts(CategoryEnum cat);

	@Query("select new com.project.model.FlightsDTO(p.name, p.retailPrice,p.description) from Flights p ")
	List<FlightsDTO>  findUserProducts();

	@Query("select new com.project.model.FlightsDTO(p.name, p.retailPrice,p.description) from Flights p where p.productId =:id ")
	List<FlightsDTO>  findUserProductsById(int id);

}
