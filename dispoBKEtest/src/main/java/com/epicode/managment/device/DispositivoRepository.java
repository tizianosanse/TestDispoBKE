package com.epicode.managment.device;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DispositivoRepository extends PagingAndSortingRepository<Dispositivo, String> {

	boolean existsById(String serialNumber);

}
