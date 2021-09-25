package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.lease.Lease;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.LeaseSummary;
import com.aakashjar.rentalmanagementapi.service.lease.LeaseService;

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
@RequestMapping("/lease")
public class LeaseController {

	@Autowired
	private LeaseService leaseService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> registerLease(@RequestBody Lease lease) {
		return leaseService.createLease(lease);
	}

	@GetMapping("/list-active")
	public ResponseEntity<List<Lease>> getActiveLeases() {
		return leaseService.getActiveLeaseList();
	}

	@GetMapping("/summary/list-active")
	public ResponseEntity<List<LeaseSummary>> getActiveLeaseSummaryList() {
		return leaseService.getActiveLeaseSummaryList();
	}

	@GetMapping("/list-active/tenant/{tenantId}")
	public ResponseEntity<List<Lease>> getActiveLeasesByTenant(@PathVariable("tenantId") Long tenantId) {
		return leaseService.getActiveLeaseListByTenant(tenantId);
	}

	@GetMapping("/summary/list-active/tenant/{tenantId}")
	public ResponseEntity<List<LeaseSummary>> getActiveLeaseSummaryListByTenant(@PathVariable("tenantId") Long tenantId) {
		return leaseService.getActiveLeaseSummaryListByTenant(tenantId);
	}

	@GetMapping("/list-terminated")
	public ResponseEntity<List<Lease>> getTerminatedLeases() {
		return leaseService.getTerminatedLeaseList();
	}

	@GetMapping("/summary/list-terminated")
	public ResponseEntity<List<LeaseSummary>> getTerminatedLeaseSummaryList() {
		return leaseService.getTerminatedLeaseSummaryList();
	}

	@GetMapping("/{leaseId}")
	public ResponseEntity<?> getLease(@PathVariable("leaseId") Long leaseId) {
		return leaseService.getLeaseData(leaseId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateLease(@RequestBody Lease lease) {
		return leaseService.updateLeaseData(lease);
	}

	@DeleteMapping("/terminate/{leaseId}")
	public ResponseEntity<ApiResponse> terminateLease(@PathVariable("leaseId") Long leaseId) {
		return leaseService.terminateLeaseData(leaseId);
	}

	@DeleteMapping("/{leaseId}")
	public ResponseEntity<ApiResponse> deleteLease(@PathVariable("leaseId") Long leaseId) {
		return leaseService.deleteLeaseData(leaseId);
	}
}
