package com.rpm.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.services.model.Customer;

/**
 * @author MohanRamu
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer>, CustomQuery<Customer> {

}
