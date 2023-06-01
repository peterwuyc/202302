package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	@NotNull(message = "Please type your email")
	private String email;
	@NotNull(message = "Please Enter your username")
	private String username;
	@NotNull(message = "Please type your password")
	private String password;
	@NotNull(message = "Please specify if it is an admin account")
	private boolean	isAdmin;
	
	

}
