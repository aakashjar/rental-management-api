package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.PropertyUnitSummary;
import com.aakashjar.rentalmanagementapi.service.propertyunit.PropertyUnitService;

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
@RequestMapping("/property-unit")
public class PropertyUnitController {

	@Autowired
	private PropertyUnitService propertyUnitService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerPropertyUnit(@RequestBody PropertyUnit propertyUnit) {
		return propertyUnitService.registerPropertyUnit(propertyUnit);
	}

	@GetMapping("/list")
	public ResponseEntity<List<PropertyUnit>> getPropertyUnits() {
		return propertyUnitService.getPropertyUnitList();
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<PropertyUnitSummary>> getPropertyUnitSummaryList() {
		return propertyUnitService.getPropertyUnitSummaryList();
	}

	@GetMapping("/summary/property/{propertyId}")
	public ResponseEntity<List<PropertyUnitSummary>> getPropertyUnits(@PathVariable("propertyId") Long propertyId) {
		return propertyUnitService.getPropertyUnitSummaryListByProperty(propertyId);
	}

	@GetMapping("/{propertyUnitId}")
	public ResponseEntity<?> getPropertyUnit(@PathVariable("propertyUnitId") Long propertyUnitId) {
		return propertyUnitService.getPropertyUnitData(propertyUnitId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updatePropertyUnit(@RequestBody PropertyUnit propertyUnit) {
		return propertyUnitService.updatePropertyUnitData(propertyUnit);
	}

	@DeleteMapping("/{propertyUnitId}")
	public ResponseEntity<ApiResponse> deletePropertyUnit(@PathVariable("propertyUnitId") Long propertyUnitId) {
		return propertyUnitService.deletePropertyUnitData(propertyUnitId);
	}

	@GetMapping("/property/{propertyId}")
	public ResponseEntity<?> getPropertyUnitsFromProperty(@PathVariable("propertyId") Long propertyId) {
		return propertyUnitService.getPropertyUnitListFromProperty(propertyId);
	}

}
