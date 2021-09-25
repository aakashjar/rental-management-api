package com.aakashjar.rentalmanagementapi.dao.landlord;

import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;

import org.springframework.data.repository.CrudRepository;

public interface LandlordDAO extends CrudRepository<Landlord, Long> {

}
