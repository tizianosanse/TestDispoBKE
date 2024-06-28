package com.epicode.managment.device;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.managment.security.users.UserDto;
@Service
public class DispositivoService {
	
	@Autowired
	DispositivoRepository deviceRepository;
	
	
	public Page<Dispositivo> findAllDevice(Pageable pageable  ) {
		return deviceRepository.findAll(pageable);
	}

	public Dispositivo findById(String id) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		return deviceRepository.findById(id).get();
	}

	public String deleteById(String id) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		deviceRepository.deleteById(id);
	
		return "Device eliminated";
	}

	public Dispositivo save(DispositivoDTO dto) {
		if (deviceRepository.existsById(dto.getSerialNumber())) {
			throw new EntityExistsException("User not found");
		}

		Dispositivo u = new Dispositivo();
		BeanUtils.copyProperties(dto, u);
		deviceRepository.save(u);
		return u;
	}

	public Dispositivo refresh(String id, Dispositivo device) {
		if (!deviceRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
	
			return	deviceRepository.save(device);
		
	}
}
