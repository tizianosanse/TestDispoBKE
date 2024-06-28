package com.epicode.managment.security.users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.managment.device.Dispositivo;
import com.epicode.managment.security.roles.Role;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.ok(userService.findAllUsers());
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.deleteById(id));
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> save(@RequestBody UserDto dto) {
		return ResponseEntity.ok(userService.save(dto));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> refresh(@PathVariable Long id, @RequestBody User user) {
		return ResponseEntity.ok(userService.refresh(id, user));
	}

	@GetMapping("/basicinformations")
	@PreAuthorize("isAutenticated()")
	public ResponseEntity<List<UserResponse>> getAllUsersBasicInformations() {
		return ResponseEntity.ok(userService.getAllUsersBasicInformations());
	}

	@GetMapping("/basicinformations/{userName}")
	@PreAuthorize("isAutenticated()")
	public ResponseEntity<UserResponse> getUserBasicInformations(String userName) {
		return ResponseEntity.ok(userService.getUserBasicInformations(userName));

	}
	
	public ResponseEntity<String> addRole(Long id,Role role) {
		userService.addRole(id, role);
		return ResponseEntity.ok("Role has been added");
	}
	public ResponseEntity<String> addDevice(Long id,Dispositivo device) {
	
		userService.addDevice(id, device);
		return ResponseEntity.ok("Device has been added");
	}
	
	
}
