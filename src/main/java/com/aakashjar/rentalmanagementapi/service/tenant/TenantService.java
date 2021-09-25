package com.aakashjar.rentalmanagementapi.service.tenant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.lease.LeaseDAO;
import com.aakashjar.rentalmanagementapi.dao.tenant.TenantDAO;
import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.TenantSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

	@Autowired
	private TenantDAO tenantDAO;

	@Autowired
	private LeaseDAO leaseDAO;

	public ResponseEntity<ApiResponse> registerTenant(Tenant tenant) {

		if (tenant != null) {
			tenant.setCreatedOn(LocalDateTime.now());
			tenantDAO.save(tenant);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Boolean.TRUE, "Tenant registered!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(Boolean.FALSE, "Tenant register failed!"));
		}
	}

	public ResponseEntity<List<Tenant>> getTenantList() {
		return ResponseEntity.ok((List<Tenant>) tenantDAO.findAll());
	}

	public ResponseEntity<List<TenantSummary>> getTenantSummaryList() {

		List<TenantSummary> currentTenantSummaryList = new ArrayList<>();

		List<Tenant> currentTenantList = (List<Tenant>) tenantDAO.findAll();

		int currentTenantLeaseCount = 0;
		for (Tenant currentTenant : currentTenantList) {
			currentTenantLeaseCount = leaseDAO.findByLeaseStatusAndTenantId('A', currentTenant.getTenantId()).size();

			TenantSummary currentTenantSummaryData = new TenantSummary(currentTenant.getTenantId(),
					currentTenant.getTenantFullName(), currentTenant.getTenantEmailAddress(),
					currentTenant.getTenantMobileNumber(), currentTenant.getTenantOccupationStatus(), currentTenantLeaseCount);

			currentTenantSummaryList.add(currentTenantSummaryData);
		}

		return ResponseEntity.ok(currentTenantSummaryList);
	}

	public ResponseEntity<?> getTenantData(Long tenantId) {

		Optional<Tenant> tenantData = tenantDAO.findById(tenantId);

		if (tenantData.isPresent()) {
			return ResponseEntity.ok(tenantData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Tenant found with corrensponding ID " + tenantId));
		}
	}

	public ResponseEntity<ApiResponse> updateTenantData(Tenant tenant) {

		Optional<Tenant> tenantData = tenantDAO.findById(tenant.getTenantId());

		if (tenantData.isPresent()) {

			tenant.setCreatedOn(tenantData.get().getCreatedOn());
			tenant.setUpdatedOn(LocalDateTime.now());
			tenantDAO.save(tenant);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Tenant updated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(Boolean.FALSE, "Tenant update failed!"));
		}
	}

	public ResponseEntity<ApiResponse> deleteTenantData(Long tenantId) {

		Optional<Tenant> tenantData = tenantDAO.findById(tenantId);

		if (tenantData.isPresent()) {

			tenantDAO.deleteById(tenantId);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Tenant removed!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(Boolean.FALSE, "Tenant remove failed!"));
		}
	}
}
