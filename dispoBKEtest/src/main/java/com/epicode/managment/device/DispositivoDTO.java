package com.epicode.managment.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDTO {
	private String serialNumber;
	private DispositivoType type;
	private DispositivoStatus status;
}
