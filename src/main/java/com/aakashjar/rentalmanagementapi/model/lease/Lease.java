package com.aakashjar.rentalmanagementapi.model.lease;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lease")
public class Lease {

	@Id
	@Column(name = "lease_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_lease_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_lease_seq", sequenceName = "rms_lease_seq")
	private long leaseId;

	@Column(name = "property_id")
	private long propertyId;

	@Column(name = "property_unit_id")
	private long propertyUnitId;

	@Column(name = "lease_rent")
	private int leaseRent;

	@Column(name = "lease_deposit_paid")
	private int leaseDepositPaid;

	@Column(name = "tenant_id")
	private long tenantId;

	@Column(name = "lease_start_date")
	private LocalDate leaseStartDate;

	@Column(name = "lease_end_date")
	private LocalDate leaseEndDate;

	@Column(name = "lease_terms", length = 5000)
	private String leaseTerms;

	@Column(name = "lease_status")
	private char leaseStatus;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Lease() {
		super();
	}

	public long getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(long leaseId) {
		this.leaseId = leaseId;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public long getPropertyUnitId() {
		return propertyUnitId;
	}

	public void setPropertyUnitId(long propertyUnitId) {
		this.propertyUnitId = propertyUnitId;
	}

	public int getLeaseRent() {
		return leaseRent;
	}

	public void setLeaseRent(int leaseRent) {
		this.leaseRent = leaseRent;
	}

	public int getLeaseDepositPaid() {
		return leaseDepositPaid;
	}

	public void setLeaseDepositPaid(int leaseDepositPaid) {
		this.leaseDepositPaid = leaseDepositPaid;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public LocalDate getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(LocalDate leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public LocalDate getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(LocalDate leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public String getLeaseTerms() {
		return leaseTerms;
	}

	public void setLeaseTerms(String leaseTerms) {
		this.leaseTerms = leaseTerms;
	}

	public char getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(char leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(leaseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lease other = (Lease) obj;
		return leaseId == other.leaseId;
	}

	@Override
	public String toString() {
		return "Lease [createdOn=" + createdOn + ", leaseDepositPaid=" + leaseDepositPaid + ", leaseEndDate=" + leaseEndDate
				+ ", leaseId=" + leaseId + ", leaseRent=" + leaseRent + ", leaseStartDate=" + leaseStartDate + ", leaseStatus="
				+ leaseStatus + ", leaseTerms=" + leaseTerms + ", propertyId=" + propertyId + ", propertyUnitId="
				+ propertyUnitId + ", tenantId=" + tenantId + ", updatedOn=" + updatedOn + "]";
	}

}
