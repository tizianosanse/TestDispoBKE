package com.epicode.managment.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.managment.configurations.DeviceConfiguration;
import com.epicode.managment.configurations.UserConfiguration;
import com.epicode.managment.device.Dispositivo;
import com.epicode.managment.device.DispositivoService;
import com.epicode.managment.security.roles.ERole;
import com.epicode.managment.security.roles.Role;
import com.epicode.managment.security.users.User;
import com.epicode.managment.security.users.UserService;

import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class Runner implements ApplicationRunner {

     UserConfiguration userConfiguration;
	
	 DeviceConfiguration deviceConfiguration;
	
	UserService userService;
	DispositivoService deviceService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		 Role r = new Role();
		 r.setRoleName(ERole.ROLE_ADMIN);
		 
		 
		userService.save(userConfiguration.newUser());
		deviceService.save(deviceConfiguration.newDevice());
		
		Dispositivo d = deviceService.findById("666");
		
	
	
		
	
	userService.addRole((long) 1, r);
	userService.addDevice((long) 1, d);
	User u = userService.findById((long) 1);
	System.out.println(u);

		
		
		
	}

}
