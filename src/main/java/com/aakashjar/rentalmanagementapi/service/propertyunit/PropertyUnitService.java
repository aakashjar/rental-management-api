package com.aakashjar.rentalmanagementapi.service.propertyunit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.lease.LeaseDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.PropertyUnitSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyUnitService {

	@Autowired
	private PropertyUnitDAO propertyUnitDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	@Autowired
	private LeaseDAO leaseDAO;

	public ResponseEntity<ApiResponse> registerPropertyUnit(PropertyUnit propertyUnit) {

		if (propertyUnit != null) {
			propertyUnit.setCreatedOn(LocalDateTime.now());
			propertyUnitDAO.save(propertyUnit);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Boolean.TRUE, "Property Unit registered!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(Boolean.FALSE, "Property Unit register failed!"));
		}
	}

	public ResponseEntity<List<PropertyUnit>> getPropertyUnitList() {
		return ResponseEntity.ok((List<PropertyUnit>) propertyUnitDAO.findAll());
	}

	public ResponseEntity<List<PropertyUnitSummary>> getPropertyUnitSummaryList() {
		return ResponseEntity.ok(getPropertyUnitSummaryList(0));
	}

	public ResponseEntity<List<PropertyUnitSummary>> getPropertyUnitSummaryListByProperty(long propertyId) {
		return ResponseEntity.ok(getPropertyUnitSummaryList(propertyId));
	}

	public ResponseEntity<?> getPropertyUnitData(Long propertyUnitId) {

		Optional<PropertyUnit> propertyUnitData = propertyUnitDAO.findById(propertyUnitId);

		if (propertyUnitData.isPresent()) {
			return ResponseEntity.ok(propertyUnitData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Property Unit found with corrensponding ID " + propertyUnitId));
		}
	}

	public ResponseEntity<ApiResponse> updatePropertyUnitData(PropertyUnit propertyUnit) {

		Optional<PropertyUnit> propertyUnitData = propertyUnitDAO.findById(propertyUnit.getPropertyUnitId());

		if (propertyUnitData.isPresent()) {

			propertyUnit.setCreatedOn(propertyUnitData.get().getCreatedOn());
			propertyUnit.setUpdatedOn(LocalDateTime.now());
			propertyUnitDAO.save(propertyUnit);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Property Unit updated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Property Unit update failed!"));
		}
	}

	public ResponseEntity<ApiResponse> deletePropertyUnitData(Long propertyUnitId) {

		Optional<PropertyUnit> propertyUnitData = propertyUnitDAO.findById(propertyUnitId);

		if (propertyUnitData.isPresent()) {

			propertyUnitDAO.deleteById(propertyUnitId);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Property Unit removed!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Property Unit remove failed!"));
		}
	}

	public ResponseEntity<?> getPropertyUnitListFromProperty(Long propertyId) {

		List<PropertyUnit> propertyUnitData = propertyUnitDAO.findByPropertyId(propertyId);

		if (propertyUnitData.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Property Unit found with corrensponding Property ID " + propertyId));
		} else {
			return ResponseEntity.ok(propertyUnitData);
		}
	}

	private List<PropertyUnitSummary> getPropertyUnitSummaryList(long propertyId) {

		List<PropertyUnitSummary> currentPropertyUnitSummaryList = new ArrayList<>();

		List<PropertyUnit> currentPropertyUnitList;

		if (propertyId > 0) {
			currentPropertyUnitList = propertyUnitDAO.findByPropertyId(propertyId);
		} else {
			currentPropertyUnitList = (List<PropertyUnit>) propertyUnitDAO.findAll();
		}

		Property currentProperty = null;

		for (PropertyUnit currentPropertyUnit : currentPropertyUnitList) {

			PropertyUnitSummary currentPropertyUnitSummaryData = new PropertyUnitSummary();

			Optional<Property> currentPropertyOptional = propertyDAO.findById(currentPropertyUnit.getPropertyId());

			if (currentPropertyOptional.isPresent()) {

				currentProperty = currentPropertyOptional.get();

				currentPropertyUnitSummaryData.setPropertyName(currentProperty.getPropertyName());

				if (leaseDAO.existsByLeaseStatusAndPropertyIdAndPropertyUnitId('A', currentPropertyUnit.getPropertyId(),
						currentPropertyUnit.getPropertyUnitId())) {
					currentPropertyUnitSummaryData.setPropertyStatus("Occupied");
				} else if (leaseDAO.existsByLeaseStatusAndPropertyIdAndPropertyUnitId('A', currentPropertyUnit.getPropertyId(),
						0)) {
					currentPropertyUnitSummaryData.setPropertyStatus("Unavailable");
				} else {
					currentPropertyUnitSummaryData.setPropertyStatus("Vacant");
				}
			}

			currentPropertyUnitSummaryData.setPropertyUnitId(currentPropertyUnit.getPropertyUnitId());
			currentPropertyUnitSummaryData.setPropertyUnitName(currentPropertyUnit.getPropertyUnitName());
			currentPropertyUnitSummaryData
					.setPropertyUnitAgencyCommission(currentPropertyUnit.getPropertyUnitAgencyCommission());
			currentPropertyUnitSummaryData.setPropertyUnitRent(currentPropertyUnit.getPropertyUnitRent());
			currentPropertyUnitSummaryData.setPropertyUnitDeposit(currentPropertyUnit.getPropertyUnitDeposit());
			currentPropertyUnitSummaryData.setPropertyUnitSummaryDescription(currentPropertyUnit.getPropertyUnitSummary());
			currentPropertyUnitSummaryData.setPropertyUnitDescription(currentPropertyUnit.getPropertyUnitDescription());
			currentPropertyUnitSummaryData.setPropertyUnitId(currentPropertyUnit.getPropertyUnitId());

			currentPropertyUnitSummaryList.add(currentPropertyUnitSummaryData);
		}

		return currentPropertyUnitSummaryList;
	}
}
