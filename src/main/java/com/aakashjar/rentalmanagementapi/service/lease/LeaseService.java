package com.aakashjar.rentalmanagementapi.service.lease;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.landlord.LandlordDAO;
import com.aakashjar.rentalmanagementapi.dao.lease.LeaseDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.dao.tenant.TenantDAO;
import com.aakashjar.rentalmanagementapi.model.invoice.Invoice;
import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.model.lease.Lease;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.LeaseSummary;
import com.aakashjar.rentalmanagementapi.service.invoice.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

	@Autowired
	private LeaseDAO leaseDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	@Autowired
	private PropertyUnitDAO propertyUnitDAO;

	@Autowired
	private LandlordDAO landlordDAO;

	@Autowired
	private TenantDAO tenantDAO;

	@Autowired
	private InvoiceService invoiceService;

	public ResponseEntity<ApiResponse> createLease(Lease lease) {

		if (lease != null) {

			Property currentProperty = null;
			PropertyUnit currentPropertyUnit = null;

			if (lease.getPropertyUnitId() > 0) {
				currentPropertyUnit = propertyUnitDAO.findById(lease.getPropertyUnitId()).get();
				lease.setLeaseDepositPaid(currentPropertyUnit.getPropertyUnitDeposit());
				lease.setLeaseRent(currentPropertyUnit.getPropertyUnitRent());
			} else {
				currentProperty = propertyDAO.findById(lease.getPropertyId()).get();
				lease.setLeaseDepositPaid(currentProperty.getPropertyDeposit());
				lease.setLeaseRent(currentProperty.getPropertyRent());
			}

			lease.setLeaseEndDate(lease.getLeaseStartDate().plusMonths(11));
			lease.setLeaseStatus('A');
			lease.setCreatedOn(LocalDateTime.now());

			Lease createdLease = leaseDAO.save(lease);

			for (int i = 0; i < 11; i++) {

				LocalDate invoiceDate = lease.getLeaseStartDate().plusMonths(i);

				Invoice currentInvoice = new Invoice();
				currentInvoice.setLeaseId(createdLease.getLeaseId());
				currentInvoice.setInvoicePeriod(invoiceDate);
				currentInvoice.setInvoiceDueDate(invoiceDate.plusDays(22));
				currentInvoice.setInvoiceAmount(lease.getLeaseRent());
				currentInvoice.setInvoiceStatus('U');
				currentInvoice.setCreatedOn(LocalDateTime.now());

				invoiceService.createInvoice(currentInvoice);
			}

			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Boolean.TRUE, "Lease created!"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(Boolean.FALSE, "Lease create failed!"));
		}

	}

	public ResponseEntity<List<Lease>> getActiveLeaseList() {
		return ResponseEntity.ok(leaseDAO.findByLeaseStatus('A'));
	}

	public ResponseEntity<List<LeaseSummary>> getActiveLeaseSummaryList() {
		return getLeaseSummaryList('A', 0);
	}

	public ResponseEntity<List<Lease>> getActiveLeaseListByTenant(long tenantId) {
		return ResponseEntity.ok(leaseDAO.findByLeaseStatusAndTenantId('A', tenantId));
	}

	public ResponseEntity<List<LeaseSummary>> getActiveLeaseSummaryListByTenant(long tenantId) {
		return getLeaseSummaryList('A', tenantId);
	}

	public ResponseEntity<List<Lease>> getTerminatedLeaseList() {
		return ResponseEntity.ok(leaseDAO.findByLeaseStatus('T'));
	}

	public ResponseEntity<List<LeaseSummary>> getTerminatedLeaseSummaryList() {
		return getLeaseSummaryList('T', 0);
	}

	public ResponseEntity<?> getLeaseData(Long leaseId) {

		Optional<Lease> leaseData = leaseDAO.findById(leaseId);

		if (leaseData.isPresent()) {
			return ResponseEntity.ok(leaseData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "No Lease found with corrensponding ID " + leaseId));
		}
	}

	public ResponseEntity<ApiResponse> updateLeaseData(Lease lease) {

		Optional<Lease> leaseData = leaseDAO.findById(lease.getLeaseId());

		if (leaseData.isPresent()) {

			Property currentProperty = null;
			PropertyUnit currentPropertyUnit = null;

			if (lease.getPropertyUnitId() > 0) {
				currentPropertyUnit = propertyUnitDAO.findById(lease.getPropertyUnitId()).get();
				lease.setLeaseDepositPaid(currentPropertyUnit.getPropertyUnitDeposit());
				lease.setLeaseRent(currentPropertyUnit.getPropertyUnitRent());
			} else {
				currentProperty = propertyDAO.findById(lease.getPropertyId()).get();
				lease.setLeaseDepositPaid(currentProperty.getPropertyDeposit());
				lease.setLeaseRent(currentProperty.getPropertyRent());
			}

			lease.setCreatedOn(leaseData.get().getCreatedOn());
			lease.setUpdatedOn(LocalDateTime.now());
			leaseDAO.save(lease);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Lease updated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(Boolean.FALSE, "Lease update failed!"));
		}
	}

	public ResponseEntity<ApiResponse> terminateLeaseData(Long leaseId) {

		Optional<Lease> leaseData = leaseDAO.findById(leaseId);

		if (leaseData.isPresent()) {

			Lease currentLeaseData = leaseData.get();
			currentLeaseData.setLeaseStatus('T');
			currentLeaseData.setUpdatedOn(LocalDateTime.now());

			leaseDAO.save(currentLeaseData);

			invoiceService.deleteInvoiceByLease(currentLeaseData.getLeaseId());

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Lease terminated!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(Boolean.FALSE, "Lease terminate failed!"));
		}
	}

	public ResponseEntity<ApiResponse> deleteLeaseData(Long leaseId) {

		Optional<Lease> leaseData = leaseDAO.findById(leaseId);

		if (leaseData.isPresent()) {

			leaseDAO.deleteById(leaseId);

			return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Lease removed!"));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(Boolean.FALSE, "Lease remove failed!"));
		}
	}

	private ResponseEntity<List<LeaseSummary>> getLeaseSummaryList(char status, long tenantId) {

		List<LeaseSummary> currentLeaseSummaryList = new ArrayList<>();

		List<Lease> currentActiveLeaseList = null;

		if (tenantId > 0) {
			currentActiveLeaseList = leaseDAO.findByLeaseStatusAndTenantId(status, tenantId);
		} else {
			currentActiveLeaseList = leaseDAO.findByLeaseStatus(status);
		}

		Property currentProperty = null;
		PropertyUnit currentPropertyUnit = null;
		Landlord currentLandlord = null;
		Tenant curreTenant = null;

		for (Lease currentActiveLease : currentActiveLeaseList) {

			LeaseSummary currentLeaseSummaryData = new LeaseSummary();

			Optional<Property> currentPropertyOptional = Optional.empty();

			Optional<Landlord> currentLandlordOptional = Optional.empty();

			Optional<Tenant> currentTenantOptional;

			if (currentActiveLease.getPropertyUnitId() > 0) {

				Optional<PropertyUnit> currentPropertyUnitOptional = propertyUnitDAO
						.findById(currentActiveLease.getPropertyUnitId());

				if (currentPropertyUnitOptional.isPresent()) {

					currentPropertyUnit = currentPropertyUnitOptional.get();

					currentLeaseSummaryData.setLeaseForName(currentPropertyUnit.getPropertyUnitName());
					currentLeaseSummaryData.setLeaseForType("Property Unit");
					currentLeaseSummaryData.setLeaseRent(currentPropertyUnit.getPropertyUnitRent());
					currentLeaseSummaryData.setLeaseDepositPaid(currentPropertyUnit.getPropertyUnitDeposit());

					currentPropertyOptional = propertyDAO.findById(currentPropertyUnit.getPropertyId());
				}

				if (currentPropertyOptional.isPresent()) {

					currentProperty = currentPropertyOptional.get();
					currentLandlordOptional = landlordDAO.findById(currentProperty.getLandlordId());
				}

				if (currentLandlordOptional.isPresent()) {

					currentLandlord = currentLandlordOptional.get();
					currentLeaseSummaryData.setLeaseLandlordName(currentLandlord.getLandlordFullName());
				}

				currentTenantOptional = tenantDAO.findById(currentActiveLease.getTenantId());

				if (currentTenantOptional.isPresent()) {

					curreTenant = currentTenantOptional.get();
					currentLeaseSummaryData.setLeaseTenantName(curreTenant.getTenantFullName());
				}

			} else {

				currentPropertyOptional = propertyDAO.findById(currentActiveLease.getPropertyId());

				if (currentPropertyOptional.isPresent()) {

					currentProperty = currentPropertyOptional.get();

					currentLeaseSummaryData.setLeaseForName(currentProperty.getPropertyName());
					currentLeaseSummaryData.setLeaseForType("Property");
					currentLeaseSummaryData.setLeaseRent(currentProperty.getPropertyRent());
					currentLeaseSummaryData.setLeaseDepositPaid(currentProperty.getPropertyDeposit());

					currentLandlordOptional = landlordDAO.findById(currentProperty.getLandlordId());
				}

				if (currentLandlordOptional.isPresent()) {

					currentLandlord = currentLandlordOptional.get();
					currentLeaseSummaryData.setLeaseLandlordName(currentLandlord.getLandlordFullName());
				}

				currentTenantOptional = tenantDAO.findById(currentActiveLease.getTenantId());

				if (currentTenantOptional.isPresent()) {

					curreTenant = currentTenantOptional.get();
					currentLeaseSummaryData.setLeaseTenantName(curreTenant.getTenantFullName());
				}
			}

			currentLeaseSummaryData.setLeaseStartDate(currentActiveLease.getLeaseStartDate());
			currentLeaseSummaryData.setLeaseEndDate(currentActiveLease.getLeaseEndDate());
			currentLeaseSummaryData.setLeaseStatus(currentActiveLease.getLeaseStatus());
			currentLeaseSummaryData.setLeaseTerms(currentActiveLease.getLeaseTerms());
			currentLeaseSummaryData.setLeaseId(currentActiveLease.getLeaseId());

			currentLeaseSummaryList.add(currentLeaseSummaryData);
		}

		return ResponseEntity.ok(currentLeaseSummaryList);

	}
}
