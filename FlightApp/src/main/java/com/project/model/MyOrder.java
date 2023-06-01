package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime datePlaced;

	String orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	User user;

	@OneToMany(cascade = CascadeType.ALL)
	List<Flights>productlist;

	@NotNull
	Integer quantity;

}
