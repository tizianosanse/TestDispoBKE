package com.epicode.managment.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.managment.security.users.UserDto;

@Configuration
public class UserConfiguration {

	@Bean("admin")
	public UserDto newUser() {
		return new UserDto("Vita98", "Vitalij Mazzucchi", "example@example.it", "12345678");
	}
	@Bean("employee")
	public UserDto newUser2() {
		return new UserDto("Pasquale69", "Pasquale Ciro", "Ciro@example.it", "12345678");
	}
}
