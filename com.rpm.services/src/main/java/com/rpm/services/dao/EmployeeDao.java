package com.rpm.services.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rpm.services.model.Employee;

public interface EmployeeDao extends MongoRepository<Employee, Integer>, CustomQuery<Employee>{

}
