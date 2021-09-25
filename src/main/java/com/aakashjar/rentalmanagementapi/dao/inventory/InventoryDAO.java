package com.aakashjar.rentalmanagementapi.dao.inventory;

import com.aakashjar.rentalmanagementapi.model.inventory.Inventory;

import org.springframework.data.repository.CrudRepository;

public interface InventoryDAO extends CrudRepository<Inventory, Long> {

}
