package com.project.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;	

	@OneToOne
	private Flights cartItem;

	@OneToOne
	private User userList;

	@ManyToOne
	@JoinColumn(name = "seatID")
	private Seats seat;

	private Integer quantity;

}
