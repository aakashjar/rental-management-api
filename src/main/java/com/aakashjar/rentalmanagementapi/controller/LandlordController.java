package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.LandlordSummary;
import com.aakashjar.rentalmanagementapi.service.landlord.LandlordService;

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
@RequestMapping("/landlord")
public class LandlordController {

	@Autowired
	private LandlordService landlordService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerLandlord(@RequestBody Landlord landlord) {
		return landlordService.registerLandlord(landlord);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Landlord>> getLandlordList() {
		return landlordService.getLandlordList();
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<LandlordSummary>> getLandlordSummaryList() {
		return landlordService.getLandlordSummaryList();
	}

	@GetMapping("/{landlordId}")
	public ResponseEntity<?> getLandlord(@PathVariable("landlordId") Long landlordId) {
		return landlordService.getLandlordData(landlordId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateLandlord(@RequestBody Landlord landlord) {
		return landlordService.updateLandlordData(landlord);
	}

	@DeleteMapping("/{landlordId}")
	public ResponseEntity<ApiResponse> deleteLandlord(@PathVariable("landlordId") Long landlordId) {
		return landlordService.deleteLandlordData(landlordId);
	}

}
