package com.rpm.services.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm.services.model.DynamicQuery;
import com.rpm.services.model.Vehicle;
import com.rpm.services.repository.VehicleRepository;
import com.rpm.services.service.VehicleService;

/**
 * @author MohanRamu
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	VehicleRepository dao;

	/**
	 * @param dao
	 */
	@Autowired
	public VehicleServiceImpl(VehicleRepository dao) {
		super();
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.VehicleService#createVehicle(com.rpm.services.model.
	 * Vehicle)
	 */
	@Override
	public void createVehicle(Vehicle vehicle) {
		dao.save(vehicle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rpm.services.service.VehicleService#createVehicles(java.util.List)
	 */
	@Override
	public void createVehicles(List<Vehicle> vehicles) {
		dao.saveAll(vehicles);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rpm.services.service.VehicleService#getAllVehicles()
	 */
	@Override
	public Collection<Vehicle> getAllVehicles() {
		return dao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rpm.services.service.VehicleService#findVehicleById(int)
	 */
	@Override
	public Optional<Vehicle> findVehicleById(int id) {
		return dao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rpm.services.service.VehicleService#deleteVehicleById(int)
	 */
	@Override
	public void deleteVehicleById(int id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.VehicleService#updateVehicle(com.rpm.services.model.
	 * Vehicle)
	 */
	@Override
	public void updateVehicle(Vehicle vehicle) {
		dao.save(vehicle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rpm.services.service.VehicleService#deleteAllVehicles()
	 */
	@Override
	public void deleteAllVehicles() {
		dao.deleteAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rpm.services.service.VehicleService#getAllVehicles(com.rpm.services.model
	 * .DynamicQuery)
	 */
	@Override
	public Collection<Vehicle> getAllVehicles(DynamicQuery dynamicQuery) {
		dynamicQuery.setEntity("com.rpm.services.model.Vehicle");
		return dao.getByDynamicQuery(dynamicQuery);
	}

}