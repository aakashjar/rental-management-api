package com.aakashjar.rentalmanagementapi.dao.propertyunit;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;

import org.springframework.data.repository.CrudRepository;

public interface PropertyUnitDAO extends CrudRepository<PropertyUnit, Long> {

	List<PropertyUnit> findByPropertyId(long propertyId);
}
