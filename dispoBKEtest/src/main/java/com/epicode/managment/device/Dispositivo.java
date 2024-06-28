package com.epicode.managment.device;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.managment.security.users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dispositivo {

	@Id
	private String serialNumber;
	private DispositivoType type;
	private DispositivoStatus status;
	@ManyToOne
	private User user;
	
	
}
