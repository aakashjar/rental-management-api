package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.property.PropertyOwnershipTransfer;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.PropertySummary;
import com.aakashjar.rentalmanagementapi.service.property.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerProperty(@RequestBody Property property) {
		return propertyService.registerProperty(property);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Property>> getPropertyList() {
		return propertyService.getPropertyList();
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<PropertySummary>> getPropertySummaryList() {
		return propertyService.getPropertySummaryList();
	}

	@GetMapping("/summary/landlord/{landlordId}")
	public ResponseEntity<List<PropertySummary>> getPropertySummaryListByLandlord(
			@PathVariable("landlordId") Long landlordId) {
		return propertyService.getPropertySummaryListByLandlord(landlordId);
	}

	@GetMapping("/list/landlord/{landlordId}")
	public ResponseEntity<List<Property>> getPropertyListByLandlord(@PathVariable("landlordId") Long landlordId) {
		return propertyService.getPropertyListByLandlord(landlordId);
	}

	@GetMapping("/{propertyId}")
	public ResponseEntity<?> getProperty(@PathVariable("propertyId") Long propertyId) {
		return propertyService.getPropertyData(propertyId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateProperty(@RequestBody Property property) {
		return propertyService.updatePropertyData(property);
	}

	@DeleteMapping("/{propertyId}")
	public ResponseEntity<ApiResponse> deleteProperty(@PathVariable("propertyId") Long propertyId) {
		return propertyService.deletePropertyData(propertyId);
	}

	@PutMapping("/transfer")
	public ResponseEntity<ApiResponse> transferPropertyOwnership(@RequestBody PropertyOwnershipTransfer transfer) {
		return propertyService.updatePropertyOwnership(transfer);
	}

}
