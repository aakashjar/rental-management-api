package com.aakashjar.rentalmanagementapi.service.inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.inventory.InventoryDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.model.inventory.Inventory;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.InventorySummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryDAO inventoryDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	@Autowired
	private PropertyUnitDAO propertyUnitDAO;

	public ResponseEntity<ApiResponse> registerInventory(Inventory inventory) {

		if (inventory != null) {
			inventory.setCreatedOn(LocalDateTime.now());
			inventoryDAO.save(inventory);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Boolean.TRUE, "Inventory created!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(Boolean.FALSE, "Inventory create failed!"));
		}

	}

	public ResponseEntity<List<Inventory>> getInventoryList() {
		return ResponseEntity.ok((List<Inventory>) inventoryDAO.findAll());
	}

	public ResponseEntity<?> getInventoryData(Long inventoryId) {

		Optional<Inventory> inventoryData = inventoryDAO.findById(inventoryId);

		if (inventoryData.isPresent()) {
			return ResponseEntity.ok(inventoryData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Inventory found with corrensponding ID " + inventoryId));
		}
	}

	public ResponseEntity<ApiResponse> updateInventoryData(Inventory inventory) {

		Optional<Inventory> inventoryData = inventoryDAO.findById(inventory.getInventoryId());

		if (inventoryData.isPresent()) {

			inventory.setCreatedOn(inventoryData.get().getCreatedOn());
			inventory.setUpdatedOn(LocalDateTime.now());
			inventoryDAO.save(inventory);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Inventory updated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Inventory update failed!"));
		}
	}

	public ResponseEntity<ApiResponse> deleteInventoryData(Long inventoryId) {

		Optional<Inventory> inventoryData = inventoryDAO.findById(inventoryId);

		if (inventoryData.isPresent()) {

			inventoryDAO.deleteById(inventoryId);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Inventory removed!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Inventory remove failed!"));
		}
	}

	public ResponseEntity<List<InventorySummary>> getInventorySummaryList() {

		List<InventorySummary> currentInventorySummaryList = new ArrayList<>();

		List<Inventory> currentInventoryList = (List<Inventory>) inventoryDAO.findAll();

		Optional<Property> currentPropertyOptional = Optional.empty();

		Property currentProperty = null;
		PropertyUnit currentPropertyUnit = null;

		for (Inventory currentInventory : currentInventoryList) {

			InventorySummary currentInventorySummaryData = new InventorySummary();

			if (currentInventory.getPropertyUnitId() > 0) {

				Optional<PropertyUnit> currentPropertyUnitOptional = propertyUnitDAO
						.findById(currentInventory.getPropertyUnitId());

				if (currentPropertyUnitOptional.isPresent()) {

					currentPropertyUnit = currentPropertyUnitOptional.get();

					currentInventorySummaryData.setInventoryForName(currentPropertyUnit.getPropertyUnitName());
					currentInventorySummaryData.setInventoryForType("Property Unit");
				}

			} else {

				currentPropertyOptional = propertyDAO.findById(currentInventory.getPropertyId());

				if (currentPropertyOptional.isPresent()) {

					currentProperty = currentPropertyOptional.get();

					currentInventorySummaryData.setInventoryForName(currentProperty.getPropertyName());
					currentInventorySummaryData.setInventoryForType("Property");
				}

			}

			currentInventorySummaryData.setPropertyUnitId(currentInventory.getPropertyUnitId());
			currentInventorySummaryData.setPropertyId(currentInventory.getPropertyId());
			currentInventorySummaryData.setInventoryId(currentInventory.getInventoryId());
			currentInventorySummaryData.setInventoryDescription(currentInventory.getInventoryDescription());
			currentInventorySummaryData.setCreatedOn(currentInventory.getCreatedOn());

			currentInventorySummaryList.add(currentInventorySummaryData);
		}

		return ResponseEntity.ok(currentInventorySummaryList);
	}
}
