package com.aakashjar.rentalmanagementapi.model.tenant;

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
@Table(name = "tenant")
public class Tenant {

	@Id
	@Column(name = "tenant_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_tenant_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_tenant_seq", sequenceName = "rms_tenant_seq")
	private long tenantId;

	@Column(name = "tenant_full_name")
	private String tenantFullName;

	@Column(name = "tenant_email_address")
	private String tenantEmailAddress;

	@Column(name = "tenant_mobile_number")
	private String tenantMobileNumber;

	@Column(name = "tenant_identity_no")
	private String tenantIdentityNumber;

	@Column(name = "tenant_address")
	private String tenantAddress;

	@Column(name = "tenant_occupation_status")
	private String tenantOccupationStatus;

	@Column(name = "tenant_occupation_place")
	private String tenantOccupationPlace;

	@Column(name = "tenant_emergency_contact_name")
	private String tenantEmergencyContactName;

	@Column(name = "tenant_emergency_contact_mobile_number")
	private String tenantEmergencyContactMobileNumber;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn = LocalDateTime.now();

	public Tenant() {
		super();
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantFullName() {
		return tenantFullName;
	}

	public void setTenantFullName(String tenantFullName) {
		this.tenantFullName = tenantFullName;
	}

	public String getTenantEmailAddress() {
		return tenantEmailAddress;
	}

	public void setTenantEmailAddress(String tenantEmailAddress) {
		this.tenantEmailAddress = tenantEmailAddress;
	}

	public String getTenantMobileNumber() {
		return tenantMobileNumber;
	}

	public void setTenantMobileNumber(String tenantMobileNumber) {
		this.tenantMobileNumber = tenantMobileNumber;
	}

	public String getTenantIdentityNumber() {
		return tenantIdentityNumber;
	}

	public void setTenantIdentityNumber(String tenantIdentityNumber) {
		this.tenantIdentityNumber = tenantIdentityNumber;
	}

	public String getTenantAddress() {
		return tenantAddress;
	}

	public void setTenantAddress(String tenantAddress) {
		this.tenantAddress = tenantAddress;
	}

	public String getTenantOccupationStatus() {
		return tenantOccupationStatus;
	}

	public void setTenantOccupationStatus(String tenantOccupationStatus) {
		this.tenantOccupationStatus = tenantOccupationStatus;
	}

	public String getTenantOccupationPlace() {
		return tenantOccupationPlace;
	}

	public void setTenantOccupationPlace(String tenantOccupationPlace) {
		this.tenantOccupationPlace = tenantOccupationPlace;
	}

	public String getTenantEmergencyContactName() {
		return tenantEmergencyContactName;
	}

	public void setTenantEmergencyContactName(String tenantEmergencyContactName) {
		this.tenantEmergencyContactName = tenantEmergencyContactName;
	}

	public String getTenantEmergencyContactMobileNumber() {
		return tenantEmergencyContactMobileNumber;
	}

	public void setTenantEmergencyContactMobileNumber(String tenantEmergencyContactMobileNumber) {
		this.tenantEmergencyContactMobileNumber = tenantEmergencyContactMobileNumber;
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
		return Objects.hash(tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tenant other = (Tenant) obj;
		return tenantId == other.tenantId;
	}

	@Override
	public String toString() {
		return "Tenant [createdOn=" + createdOn + ", tenantAddress=" + tenantAddress + ", tenantEmailAddress="
				+ tenantEmailAddress + ", tenantEmergencyContactMobileNumber=" + tenantEmergencyContactMobileNumber
				+ ", tenantEmergencyContactName=" + tenantEmergencyContactName + ", tenantFullName=" + tenantFullName
				+ ", tenantId=" + tenantId + ", tenantIdentityNumber=" + tenantIdentityNumber + ", tenantMobileNumber="
				+ tenantMobileNumber + ", tenantOccupationPlace=" + tenantOccupationPlace + ", tenantOccupationStatus="
				+ tenantOccupationStatus + ", updatedOn=" + updatedOn + "]";
	}

}
