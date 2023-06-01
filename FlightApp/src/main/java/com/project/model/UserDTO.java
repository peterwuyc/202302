package com.project.model;

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
public class UserDTO {
	
	@NotNull(message = "Enter Your username")
	private String username;
	@NotNull(message = "Enter Your Password")
	private String password;
	
}
