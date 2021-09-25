package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.TenantSummary;
import com.aakashjar.rentalmanagementapi.service.tenant.TenantService;

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
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private TenantService tenantService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerTenant(@RequestBody Tenant tenant) {
		return tenantService.registerTenant(tenant);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tenant>> getTenantList() {
		return tenantService.getTenantList();
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<TenantSummary>> getTenantSummaryList() {
		return tenantService.getTenantSummaryList();
	}

	@GetMapping("/{tenantId}")
	public ResponseEntity<?> getTenant(@PathVariable("tenantId") Long tenantId) {
		return tenantService.getTenantData(tenantId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateTenant(@RequestBody Tenant tenant) {
		return tenantService.updateTenantData(tenant);
	}

	@DeleteMapping("/{tenantId}")
	public ResponseEntity<ApiResponse> deleteTenant(@PathVariable("tenantId") Long tenantId) {
		return tenantService.deleteTenantData(tenantId);
	}
}
