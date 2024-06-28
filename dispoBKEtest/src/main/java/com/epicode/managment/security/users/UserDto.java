package com.epicode.managment.security.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String username;
	private String nameAndSurname;
	private String email;
	private String password;
}

