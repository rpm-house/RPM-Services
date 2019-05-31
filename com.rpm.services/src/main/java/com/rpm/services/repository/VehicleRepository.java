package com.rpm.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.services.model.Vehicle;

/**
 * @author MohanRamu
 *
 */
public interface VehicleRepository extends MongoRepository<Vehicle, Integer>, CustomQuery<Vehicle> {

}
