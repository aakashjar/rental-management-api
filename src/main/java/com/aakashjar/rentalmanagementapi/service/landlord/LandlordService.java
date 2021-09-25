package com.aakashjar.rentalmanagementapi.service.landlord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.landlord.LandlordDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.LandlordSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LandlordService {

    @Autowired
    private LandlordDAO landlordDAO;

    @Autowired
    private PropertyDAO propertyDAO;

    @Autowired
    private PropertyUnitDAO propertyUnitDAO;

    public ResponseEntity<ApiResponse> registerLandlord(Landlord landlord) {

        if (landlord != null) {
            landlord.setCreatedOn(LocalDateTime.now());
            landlordDAO.save(landlord);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(Boolean.TRUE, "Landlord registered!"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(Boolean.FALSE, "Landlord register failed!"));
        }

    }

    public ResponseEntity<List<Landlord>> getLandlordList() {
        return ResponseEntity.ok((List<Landlord>) landlordDAO.findAll());
    }

    public ResponseEntity<List<LandlordSummary>> getLandlordSummaryList() {

        List<LandlordSummary> currentLandlordSummaryList = new ArrayList<>();

        List<Landlord> currentLandlordList = (List<Landlord>) landlordDAO.findAll();

        currentLandlordList.forEach(currentLandlord -> {

            List<Property> currentLandlordPropertyList = propertyDAO.findByLandlordId(currentLandlord.getLandlordId());

            int currentLandlordPropertyUnitCount = 0;
            for (Property currentLandlordProperty : currentLandlordPropertyList) {
                currentLandlordPropertyUnitCount = propertyUnitDAO
                        .findByPropertyId(currentLandlordProperty.getPropertyId()).size();
            }

            LandlordSummary currentLandlordSummaryData = new LandlordSummary(currentLandlord.getLandlordId(),
                    currentLandlord.getLandlordFullName(), currentLandlord.getLandlordEmailAddress(),
                    currentLandlord.getLandlordMobileNumber(), currentLandlordPropertyList.size(),
                    currentLandlordPropertyUnitCount);

            currentLandlordSummaryList.add(currentLandlordSummaryData);
        });

        return ResponseEntity.ok(currentLandlordSummaryList);
    }

    public ResponseEntity<?> getLandlordData(Long landlordId) {

        Optional<Landlord> landlordData = landlordDAO.findById(landlordId);

        if (landlordData.isPresent()) {
            return ResponseEntity.ok(landlordData.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(Boolean.FALSE, "No Landlord found with corrensponding ID " + landlordId));
        }
    }

    public ResponseEntity<ApiResponse> updateLandlordData(Landlord landlord) {

        Optional<Landlord> landlordData = landlordDAO.findById(landlord.getLandlordId());

        if (landlordData.isPresent()) {

            landlord.setCreatedOn(landlordData.get().getCreatedOn());
            landlord.setUpdatedOn(LocalDateTime.now());
            landlordDAO.save(landlord);

            return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Landlord updated!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(Boolean.FALSE, "Landlord update failed!"));
        }
    }

    public ResponseEntity<ApiResponse> deleteLandlordData(Long landlordId) {

        Optional<Landlord> landlordData = landlordDAO.findById(landlordId);

        if (landlordData.isPresent()) {

            landlordDAO.deleteById(landlordId);

            return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Landlord removed!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(Boolean.FALSE, "Landlord remove failed!"));
        }
    }
}
