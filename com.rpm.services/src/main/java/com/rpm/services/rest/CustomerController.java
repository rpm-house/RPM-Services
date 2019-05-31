package com.rpm.services.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpm.services.model.DynamicQuery;
import com.rpm.services.model.Customer;
import com.rpm.services.service.CustomerService;

/**
 * @author MohanRamu
 *
 */
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save customers in the db.
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/create")
	public String create(@RequestBody Customer customer) {
		logger.debug("Saving customers.");
		service.createCustomer(customer);
		return "Customer records created.";
	}

	/**
	 * Method to save customers in the db.
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/createAll")
	public String createAll(@RequestBody List<Customer> customer) {
		logger.debug("Saving customers.");
		service.createCustomers(customer);
		return "Customer records created.";
	}

	/**
	 * Method to fetch all customers from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall")
	public Collection<Customer> getAll() {
		logger.debug("Getting all customers.");
		return service.getAllCustomers();
	}

	/**
	 * Method to fetch all customers from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall/{key}/{value}/{operator}")
	public Collection<Customer> getAllByDynamicQuery(@PathVariable(value = "key") String key,
			@PathVariable(value = "value") String value, @PathVariable(value = "operator") String operator) {
		logger.debug("Getting all customers.");
		DynamicQuery dynamicQuery = new DynamicQuery();
		dynamicQuery.setKey(key);
		dynamicQuery.setValue(value);
		dynamicQuery.setOperator(operator);
		return service.getAllCustomers(dynamicQuery);
	}

	/**
	 * Method to fetch customer by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getbyid/{customer-id}")
	public Optional<Customer> getById(@PathVariable(value = "customer-id") int id) {
		logger.debug("Getting customer with customer-id= {}.", id);
		return service.findCustomerById(id);
	}

	/**
	 * Method to update customer by id.
	 * 
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value = "/update/{customer-id}")
	public String update(@PathVariable(value = "customer-id") int id, @RequestBody Customer e) {
		logger.debug("Updating customer with customer-id= {}.", id);
		e.setCustomerId(id);
		service.updateCustomer(e);
		return "Customer record for customer-id= " + id + " updated.";
	}

	/**
	 * Method to delete customer by id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{customer-id}")
	public String delete(@PathVariable(value = "customer-id") int id) {
		logger.debug("Deleting customer with customer-id= {}.", id);
		service.deleteCustomerById(id);
		return "Customer record for customer-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all customers from the db.
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all customers.");
		service.deleteAllCustomers();
		return "All customer records deleted.";
	}
}