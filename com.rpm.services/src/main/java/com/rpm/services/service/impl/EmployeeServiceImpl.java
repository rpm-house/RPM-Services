package com.rpm.services.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm.services.model.DynamicQuery;
import com.rpm.services.model.Employee;
import com.rpm.services.repository.CustomQuery;
import com.rpm.services.repository.EmployeeRepository;
import com.rpm.services.service.EmployeeService;

/**
 * @author MohanRamu
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// The dao repository will use the Mongodb-Repository to perform the database
	// operations.
	// @Autowired
	EmployeeRepository dao;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository dao, CustomQuery<Employee> customQuery) {
		super();
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.
	 * util.List)
	 */
	public void createEmployee(Employee emp) {
		dao.save(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.
	 * util.List)
	 */
	public void createEmployees(List<Employee> emp) {
		dao.saveAll(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
	 */
	public Collection<Employee> getAllEmployees() {
		return dao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#findEmployeeById(int)
	 */
	public Optional<Employee> findEmployeeById(int id) {
		return dao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#deleteEmployeeById(
	 * int)
	 */
	public void deleteEmployeeById(int id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#updateEmployee(int)
	 */
	public void updateEmployee(Employee emp) {
		dao.save(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#deleteAllEmployees()
	 */
	public void deleteAllEmployees() {
		dao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.EmployeeService#getAllEmployees(com.rpm.services.
	 * model.DynamicQuery)
	 */
	@Override
	public Collection<Employee> getAllEmployees(DynamicQuery dynamicQuery) {
		dynamicQuery.setEntity("com.rpm.services.model.Employee");
		return dao.getByDynamicQuery(dynamicQuery);
	}

}