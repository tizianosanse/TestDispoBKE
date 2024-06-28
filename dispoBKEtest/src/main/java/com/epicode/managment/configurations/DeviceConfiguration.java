package com.epicode.managment.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.managment.device.DispositivoDTO;
import com.epicode.managment.device.DispositivoStatus;
import com.epicode.managment.device.DispositivoType;

@Configuration
public class DeviceConfiguration {

	@Bean("device1")
	public DispositivoDTO newDevice() {
		return new DispositivoDTO("666", DispositivoType.SMARTPHONE, DispositivoStatus.AVAILABLE);
	}
	@Bean("device2")
	public DispositivoDTO newDevice2() {
		return new DispositivoDTO("333", DispositivoType.SMARTPHONE, DispositivoStatus.MAINTENANCE);
	}
	
	
}
