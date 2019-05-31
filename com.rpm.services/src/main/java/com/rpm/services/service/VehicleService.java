package com.rpm.services.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.rpm.services.model.DynamicQuery;
import com.rpm.services.model.Vehicle;

/**
 * @author MohanRamu
 *
 */
public interface VehicleService {

	/**
	 * Method to create new Vehicles in the db using mongo-db repository.
	 * 
	 * @param vehicle
	 */
	public void createVehicle(Vehicle vehicle);

	/**
	 * Method to create new Vehicles in the db using mongo-db repository.
	 * 
	 * @param vehicle
	 */
	public void createVehicles(List<Vehicle> vehicles);

	/**
	 * Method to fetch all Vehicles from the db using mongo-db repository.
	 * 
	 * @return
	 */
	public Collection<Vehicle> getAllVehicles();

	/**
	 * Method to fetch Vehicle by id using mongo-db repository.
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Vehicle> findVehicleById(int id);

	/**
	 * Method to delete Vehicle by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void deleteVehicleById(int id);

	/**
	 * Method to update Vehicle by id using mongo-db repository.
	 * 
	 * @param id
	 */
	public void updateVehicle(Vehicle vehicle);

	/**
	 * Method to delete all Vehicles using mongo-db repository.
	 */
	public void deleteAllVehicles();

	/**
	 * Method to Search Vehicles using mongo-db repository.
	 */
	public Collection<Vehicle> getAllVehicles(DynamicQuery dynamicQuery);
}