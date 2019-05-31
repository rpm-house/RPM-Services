package com.rpm.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.services.model.Employee;

/**
 * @author MohanRamu
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, Integer>, CustomQuery<Employee> {

}
