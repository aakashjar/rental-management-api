package com.aakashjar.rentalmanagementapi.payload;

import java.util.Objects;

public class TenantSummary {

	private long tenantId;
	private String tenantFullName;
	private String tenantEmailAddress;
	private String tenantMobileNumber;
	private String tenantOccupationStatus;
	private int tenantLeaseCount;

	public TenantSummary() {
		super();
	}

	public TenantSummary(long tenantId, String tenantFullName, String tenantEmailAddress, String tenantMobileNumber,
			String tenantOccupationStatus, int tenantLeaseCount) {
		this.tenantId = tenantId;
		this.tenantFullName = tenantFullName;
		this.tenantEmailAddress = tenantEmailAddress;
		this.tenantMobileNumber = tenantMobileNumber;
		this.tenantOccupationStatus = tenantOccupationStatus;
		this.tenantLeaseCount = tenantLeaseCount;
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

	public String getTenantOccupationStatus() {
		return tenantOccupationStatus;
	}

	public void setTenantOccupationStatus(String tenantOccupationStatus) {
		this.tenantOccupationStatus = tenantOccupationStatus;
	}

	public int getTenantLeaseCount() {
		return tenantLeaseCount;
	}

	public void setTenantLeaseCount(int tenantLeaseCount) {
		this.tenantLeaseCount = tenantLeaseCount;
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
		TenantSummary other = (TenantSummary) obj;
		return tenantId == other.tenantId;
	}

	@Override
	public String toString() {
		return "TenantSummary [tenantEmailAddress=" + tenantEmailAddress + ", tenantFullName=" + tenantFullName
				+ ", tenantId=" + tenantId + ", tenantLeaseCount=" + tenantLeaseCount + ", tenantMobileNumber="
				+ tenantMobileNumber + ", tenantOccupationStatus=" + tenantOccupationStatus + "]";
	}

}
