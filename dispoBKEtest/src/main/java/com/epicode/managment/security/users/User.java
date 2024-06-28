package com.epicode.managment.security.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.epicode.managment.device.Dispositivo;
import com.epicode.managment.security.roles.Role;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;


	@NotBlank
	@Size(max = 100)
	private String nameAndSurname;
	
	@NotBlank
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String password;
	
	

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	@OneToMany(fetch = FetchType.EAGER)
	private List<Dispositivo> devices = new ArrayList<Dispositivo>();

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 100) String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public void adddevice(Dispositivo device) {
		devices.add(device);
	}






	


}
