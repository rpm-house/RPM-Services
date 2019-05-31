package com.rpm.services.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Mongo database annotation.
@Document(collection = "customer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6970330169715246177L;

	@Id
	private int customerId;
	
	private String customerName;
	
	private List<Vehicle> vehicles;
	
	private Contact contact;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
}
