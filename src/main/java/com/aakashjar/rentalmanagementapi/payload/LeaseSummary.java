package com.aakashjar.rentalmanagementapi.payload;

import java.time.LocalDate;
import java.util.Objects;

public class LeaseSummary {

	private long leaseId;
	private String leaseForName;
	private String leaseLandlordName;
	private String leaseTenantName;
	private String leaseForType;
	private int leaseRent;
	private int leaseDepositPaid;
	private LocalDate leaseStartDate;
	private LocalDate leaseEndDate;
	private char leaseStatus;
	private String leaseTerms;

	public LeaseSummary() {
		super();
	}

	public long getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(long leaseId) {
		this.leaseId = leaseId;
	}

	public String getLeaseForName() {
		return leaseForName;
	}

	public void setLeaseForName(String leaseForName) {
		this.leaseForName = leaseForName;
	}

	public String getLeaseLandlordName() {
		return leaseLandlordName;
	}

	public void setLeaseLandlordName(String leaseLandlordName) {
		this.leaseLandlordName = leaseLandlordName;
	}

	public String getLeaseTenantName() {
		return leaseTenantName;
	}

	public void setLeaseTenantName(String leaseTenantName) {
		this.leaseTenantName = leaseTenantName;
	}

	public String getLeaseForType() {
		return leaseForType;
	}

	public void setLeaseForType(String leaseForType) {
		this.leaseForType = leaseForType;
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

	public char getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(char leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	public String getLeaseTerms() {
		return leaseTerms;
	}

	public void setLeaseTerms(String leaseTerms) {
		this.leaseTerms = leaseTerms;
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
		LeaseSummary other = (LeaseSummary) obj;
		return leaseId == other.leaseId;
	}

	@Override
	public String toString() {
		return "LeaseSummary [leaseDepositPaid=" + leaseDepositPaid + ", leaseEndDate=" + leaseEndDate + ", leaseForName="
				+ leaseForName + ", leaseForType=" + leaseForType + ", leaseId=" + leaseId + ", leaseLandlordName="
				+ leaseLandlordName + ", leaseRent=" + leaseRent + ", leaseStartDate=" + leaseStartDate + ", leaseStatus="
				+ leaseStatus + ", leaseTenantName=" + leaseTenantName + ", leaseTerms=" + leaseTerms + "]";
	}

}
