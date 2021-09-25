package com.aakashjar.rentalmanagementapi.service.property;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aakashjar.rentalmanagementapi.dao.landlord.LandlordDAO;
import com.aakashjar.rentalmanagementapi.dao.lease.LeaseDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.property.PropertyOwnershipTransfer;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.PropertySummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

	@Autowired
	private PropertyDAO propertyDAO;

	@Autowired
	private LeaseDAO leaseDAO;

	@Autowired
	private LandlordDAO landlordDAO;

	@Autowired
	private PropertyUnitDAO propertyUnitDAO;

	public ResponseEntity<ApiResponse> registerProperty(Property property) {

		if (property != null) {
			property.setCreatedOn(LocalDateTime.now());
			propertyDAO.save(property);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Boolean.TRUE, "Property registered!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(Boolean.FALSE, "Property register failed!"));
		}

	}

	public ResponseEntity<List<Property>> getPropertyList() {
		return ResponseEntity.ok((List<Property>) propertyDAO.findAll());
	}

	public ResponseEntity<List<Property>> getPropertyListByLandlord(long landlordId) {
		return ResponseEntity.ok(propertyDAO.findByLandlordId(landlordId));
	}

	public ResponseEntity<?> getPropertyData(Long propertyId) {

		Optional<Property> propertyData = propertyDAO.findById(propertyId);

		if (propertyData.isPresent()) {
			return ResponseEntity.ok(propertyData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Property found with corrensponding ID " + propertyId));
		}
	}

	public ResponseEntity<ApiResponse> updatePropertyData(Property property) {

		Optional<Property> propertyData = propertyDAO.findById(property.getPropertyId());

		if (propertyData.isPresent()) {

			property.setCreatedOn(propertyData.get().getCreatedOn());
			property.setUpdatedOn(LocalDateTime.now());
			propertyDAO.save(property);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Property updated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Property update failed!"));
		}
	}

	public ResponseEntity<ApiResponse> deletePropertyData(Long propertyId) {

		Optional<Property> propertyData = propertyDAO.findById(propertyId);

		if (propertyData.isPresent()) {

			propertyDAO.deleteById(propertyId);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Property removed!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Property remove failed!"));
		}
	}

	public ResponseEntity<ApiResponse> updatePropertyOwnership(PropertyOwnershipTransfer propertyOwnershipTransfer) {

		Optional<Property> propertyData = propertyDAO.findById(propertyOwnershipTransfer.getPropertyId());

		if (propertyData.isPresent()) {

			Property currentProperty = propertyData.get();

			currentProperty.setLandlordId(propertyOwnershipTransfer.getLandlordId());
			currentProperty.setUpdatedOn(LocalDateTime.now());
			propertyDAO.save(currentProperty);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Property ownership transfer complete!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Property ownership transfer failed!"));
		}
	}

	public ResponseEntity<List<PropertySummary>> getPropertySummaryList() {
		return ResponseEntity.ok(getPropertySummaryList(0));
	}

	public ResponseEntity<List<PropertySummary>> getPropertySummaryListByLandlord(Long landlordId) {
		return ResponseEntity.ok(getPropertySummaryList(landlordId));
	}

	public List<PropertySummary> getPropertySummaryList(long landlordId) {

		List<PropertySummary> currentPropertySummaryList = new ArrayList<>();

		List<Property> currentPropertyList;

		if (landlordId > 0) {
			currentPropertyList = propertyDAO.findByLandlordId(landlordId);
		} else {
			currentPropertyList = (List<Property>) propertyDAO.findAll();
		}

		currentPropertyList.forEach(currentProperty -> {

			PropertySummary currentPropertySummaryData = new PropertySummary();

			int currentPropertyUnitCount = propertyUnitDAO.findByPropertyId(currentProperty.getPropertyId()).size();

			Optional<Landlord> currentLandlordOptional = landlordDAO.findById(currentProperty.getLandlordId());

			if (currentLandlordOptional.isPresent()) {
				currentPropertySummaryData.setPropertyLandlordName(currentLandlordOptional.get().getLandlordFullName());
			}

			boolean isPropertyLeased = false;
			boolean isPropertyUnitLeased = false;

			if (leaseDAO.existsByLeaseStatusAndPropertyId('A', currentProperty.getPropertyId())) {

				isPropertyLeased = true;

				isPropertyUnitLeased = !leaseDAO.findByLeaseStatusAndPropertyId('A', currentProperty.getPropertyId()).stream()
						.filter(currentLease -> currentLease.getPropertyUnitId() > 0).collect(Collectors.toList()).isEmpty();
			}

			if (isPropertyUnitLeased) {
				currentPropertySummaryData.setPropertyStatus("Occupied");
			} else if (isPropertyLeased) {
				currentPropertySummaryData.setPropertyStatus("Occupied");
			} else {
				currentPropertySummaryData.setPropertyStatus("Vacant");
			}

			currentPropertySummaryData.setPropertyId(currentProperty.getPropertyId());
			currentPropertySummaryData.setPropertyName(currentProperty.getPropertyName());
			currentPropertySummaryData.setPropertyRent(currentProperty.getPropertyRent());
			currentPropertySummaryData.setPropertyType(currentProperty.getPropertyType());
			currentPropertySummaryData.setPropertyArea(currentProperty.getPropertyArea());
			currentPropertySummaryData.setPropertyAgencyCommission(currentProperty.getPropertyAgencyCommission());
			currentPropertySummaryData.setPropertyDeposit(currentProperty.getPropertyDeposit());
			currentPropertySummaryData.setPropertyCity(currentProperty.getPropertyCity());
			currentPropertySummaryData.setPropertyUnitCount(currentPropertyUnitCount);

			currentPropertySummaryList.add(currentPropertySummaryData);
		});

		return currentPropertySummaryList;
	}
}
