package com.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FlightsDTO {
	
	@NotNull(message = "please input a valid product name")
	private String name;
	@NotNull(message = "please input a valid product price")
	private Double price;
	@NotNull
	private String description;
	
	public FlightsDTO() {
		// TODO Auto-generated constructor stub
	}

	public FlightsDTO(String name, Double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductsDTO [productName=" + name + ", price=" + price + "]";
	}
	
	
}
