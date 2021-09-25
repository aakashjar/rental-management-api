package com.aakashjar.rentalmanagementapi.dao.property;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.property.Property;

import org.springframework.data.repository.CrudRepository;

public interface PropertyDAO extends CrudRepository<Property, Long> {

	List<Property> findByLandlordId(long landlordId);
}
