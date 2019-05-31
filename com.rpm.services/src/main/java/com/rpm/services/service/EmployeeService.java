package com.rpm.services.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.rpm.services.model.DynamicQuery;
import com.rpm.services.model.Employee;

/**
 * @author MohanRamu
 *
 */
public interface EmployeeService {

	/**
	 * Method to create new employees in the db using mongo-db repository.
	 * 
	 * @param emp
	 */
	public void createEmployee(Employee emp);

	/**
	 * Method to create new employees in the db using mongo-db repository.
	 * 
	 * @param emp
	 */
	public void createEmployees(List<Employee> emp);

	/**
	 * Method to fetch all employees from the db using mongo-db repository.
	 * 
	 * @return
	 */
	public Collection<Employee> getAllEmployees();

	/**
	 * Method to fetch employee by id using mongo-db repository.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Employee> findEmployeeById(int id);

	/**
	 * Method to delete employee by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void deleteEmployeeById(int id);

	/**
	 * Method to update employee by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void updateEmployee(Employee emp);

	/**
	 * Method to delete all employees using mongo-db repository.
	 */
	public void deleteAllEmployees();

	public Collection<Employee> getAllEmployees(DynamicQuery dynamicQuery);
}