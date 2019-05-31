package com.rpm.services.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.rpm.services.model.Customer;
import com.rpm.services.model.DynamicQuery;

/**
 * @author MohanRamu
 *
 */
public interface CustomerService {

	/**
	 * Method to create new customers in the db using mongo-db repository.
	 * 
	 * @param customer
	 */
	public void createCustomer(Customer customer);

	/**
	 * Method to create new customers in the db using mongo-db repository.
	 * 
	 * @param customer
	 */
	public void createCustomers(List<Customer> customer);

	/**
	 * Method to fetch all customers from the db using mongo-db repository.
	 * 
	 * @return
	 */
	public Collection<Customer> getAllCustomers();

	/**
	 * Method to fetch customer by id using mongo-db repository.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Customer> findCustomerById(int id);

	/**
	 * Method to delete customer by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void deleteCustomerById(int id);

	/**
	 * Method to update customer by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void updateCustomer(Customer customer);

	/**
	 * Method to delete all customers using mongo-db repository.
	 */
	public void deleteAllCustomers();

	public Collection<Customer> getAllCustomers(DynamicQuery dynamicQuery);
}