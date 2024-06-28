package com.epicode.managment.security.users;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.managment.device.Dispositivo;
import com.epicode.managment.device.DispositivoService;
import com.epicode.managment.security.roles.Role;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	 DispositivoService deviceService;

	public List<UserResponse> getAllUsersBasicInformations() {
		return userRepository.findAll().stream()
				.map(user -> UserResponse.builder().userName(user.getUsername())
						.role(user.getRoles().stream().findFirst().get().getRoleName().name()).build())
				.collect(Collectors.toList());
	}

	public UserResponse getUserBasicInformations(String userName) {
		User user = userRepository.findByUsername(userName).get();

		return UserResponse.builder().userName(userName)
				.role(user.getRoles().stream().findFirst().get().getRoleName().name()).build();

	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		return userRepository.findById(id).get();
	}

	public String deleteById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		userRepository.deleteById(id);
		return "User soppressed";
		
	}

	public User save(UserDto dto) {
		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new EntityExistsException("User not found");
		}

		User u = new User();
		BeanUtils.copyProperties(dto, u);
		userRepository.save(u);
		return u;
	}

	public User refresh(Long id, User user) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
	
		return userRepository.save(user);
		
	}
	
	public void addRole(Long id,Role role) {
		User u = findById(id);
		u.addRole(role);
		refresh(id, u);
	}
	public void addDevice(Long id,Dispositivo device) {
		User u = findById(id);
		u.adddevice(device);
		refresh(id, u);
		
	}

}
