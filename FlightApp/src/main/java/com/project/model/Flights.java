package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Flights {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@NotNull
	private String name;
	@NotNull
	private Double retailPrice;
	@NotNull
	private Double wholesalePrice;
	@NotNull
	private String description;
	@Min(value = 1,message = "quantity should be minimum one")
	private Integer stockQuantity;

	@NotNull
	private String origin;
	@NotNull
	private String destination;
	@NotNull
	private int availableSeats;
	@NotNull
	private double price;

}
