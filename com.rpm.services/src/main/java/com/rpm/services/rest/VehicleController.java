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
import com.rpm.services.model.Vehicle;
import com.rpm.services.service.VehicleService;

/**
 * @author MohanRamu
 *
 */
@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

	@Autowired
	VehicleService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save vehicles in the db.
	 * 
	 * @param emp
	 * @return
	 */
	@PostMapping(value = "/create")
	public String create(@RequestBody Vehicle vehicle) {
		logger.debug("Saving Vehicle.");
		service.createVehicle(vehicle);
		return "Vehicle record created.";
	}

	/**
	 * Method to save vehicles in the db.
	 * 
	 * @param emp
	 * @return
	 */
	@PostMapping(value = "/createAll")
	public String createAll(@RequestBody List<Vehicle> emp) {
		logger.debug("Saving vehicles.");
		service.createVehicles(emp);
		return "Vehicle records created.";
	}

	/**
	 * Method to fetch all vehicles from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall")
	public Collection<Vehicle> getAll() {
		logger.debug("Getting all Vehicles.");
		return service.getAllVehicles();
	}

	/**
	 * Method to fetch all vehicles from the db.
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall/{key}/{value}/{operator}")
	public Collection<Vehicle> getAllByDynamicQuery(@PathVariable(value = "key") String key,
			@PathVariable(value = "value") String value, @PathVariable(value = "operator") String operator) {
		logger.debug("Getting all vehicles.");
		DynamicQuery dynamicQuery = new DynamicQuery();
		dynamicQuery.setKey(key);
		dynamicQuery.setValue(value);
		dynamicQuery.setOperator(operator);
		return service.getAllVehicles(dynamicQuery);
	}

	/**
	 * Method to fetch vehicle by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getbyid/{vehicle-id}")
	public Optional<Vehicle> getById(@PathVariable(value = "vehicle-id") int id) {
		logger.debug("Getting Vehicle with vehicle-id= {}.", id);
		return service.findVehicleById(id);
	}

	/**
	 * Method to update vehicle by id.
	 * 
	 * @param vehicleId
	 * @return
	 */
	@PutMapping(value = "/update/{vehicle-id}")
	public String update(@PathVariable(value = "vehicle-id") int vehicleId, @RequestBody Vehicle vehicle) {
		logger.debug("Updating vehicle with vehicle-id= {}.", vehicleId);
		vehicle.setVehicleId(vehicleId);
		service.updateVehicle(vehicle);
		return "Vehicle record for vehicle-id= " + vehicleId + " updated.";
	}

	/**
	 * Method to delete vehicle by id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{vehicle-id}")
	public String delete(@PathVariable(value = "vehicle-id") int id) {
		logger.debug("Deleting vehicle with vehicle-id= {}.", id);
		service.deleteVehicleById(id);
		return "Vehicle record for vehicle-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all vehicles from the db.
	 * 
	 * @return
	 */
	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all vehicles.");
		service.deleteAllVehicles();
		return "All vehicle records deleted.";
	}
}