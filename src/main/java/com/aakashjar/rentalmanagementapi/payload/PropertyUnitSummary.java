package com.aakashjar.rentalmanagementapi.payload;

import java.util.Objects;

public class PropertyUnitSummary {

	private long propertyUnitId;
	private String propertyUnitName;
	private String propertyName;
	private float propertyUnitAgencyCommission;
	private int propertyUnitRent;
	private int propertyUnitDeposit;
	private String propertyUnitSummaryDescription;
	private String propertyUnitDescription;
	private String propertyStatus;

	public PropertyUnitSummary() {
		super();
	}

	public long getPropertyUnitId() {
		return propertyUnitId;
	}

	public void setPropertyUnitId(long propertyUnitId) {
		this.propertyUnitId = propertyUnitId;
	}

	public String getPropertyUnitName() {
		return propertyUnitName;
	}

	public void setPropertyUnitName(String propertyUnitName) {
		this.propertyUnitName = propertyUnitName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public float getPropertyUnitAgencyCommission() {
		return propertyUnitAgencyCommission;
	}

	public void setPropertyUnitAgencyCommission(float propertyUnitAgencyCommission) {
		this.propertyUnitAgencyCommission = propertyUnitAgencyCommission;
	}

	public int getPropertyUnitRent() {
		return propertyUnitRent;
	}

	public void setPropertyUnitRent(int propertyUnitRent) {
		this.propertyUnitRent = propertyUnitRent;
	}

	public int getPropertyUnitDeposit() {
		return propertyUnitDeposit;
	}

	public void setPropertyUnitDeposit(int propertyUnitDeposit) {
		this.propertyUnitDeposit = propertyUnitDeposit;
	}

	public String getPropertyUnitSummaryDescription() {
		return propertyUnitSummaryDescription;
	}

	public void setPropertyUnitSummaryDescription(String propertyUnitSummaryDescription) {
		this.propertyUnitSummaryDescription = propertyUnitSummaryDescription;
	}

	public String getPropertyUnitDescription() {
		return propertyUnitDescription;
	}

	public void setPropertyUnitDescription(String propertyUnitDescription) {
		this.propertyUnitDescription = propertyUnitDescription;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(propertyUnitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyUnitSummary other = (PropertyUnitSummary) obj;
		return propertyUnitId == other.propertyUnitId;
	}

	@Override
	public String toString() {
		return "PropertyUnitSummary [propertyName=" + propertyName + ", propertyStatus=" + propertyStatus
				+ ", propertyUnitAgencyCommission=" + propertyUnitAgencyCommission + ", propertyUnitDeposit="
				+ propertyUnitDeposit + ", propertyUnitDescription=" + propertyUnitDescription + ", propertyUnitId="
				+ propertyUnitId + ", propertyUnitName=" + propertyUnitName + ", propertyUnitRent=" + propertyUnitRent
				+ ", propertyUnitSummaryDescription=" + propertyUnitSummaryDescription + "]";
	}

}