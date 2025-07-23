package com.jao.booking.respository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jao.booking.entity.VueloEntity;

public interface VueloRepository extends MongoRepository<VueloEntity, String>{
	
	Optional<VueloEntity> findByCodigoVuelo(String codigoVuelo);


}
