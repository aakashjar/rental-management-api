package com.aakashjar.rentalmanagementapi.payload;

import java.util.Objects;

public class PropertySummary {

	private long propertyId;
	private String propertyName;
	private int propertyRent;
	private String propertyType;
	private float propertyArea;
	private float propertyAgencyCommission;
	private int propertyDeposit;
	private String propertyCity;
	private String propertyStatus;
	private String propertyLandlordName;
	private int propertyUnitCount;

	public PropertySummary() {
		super();
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getPropertyRent() {
		return propertyRent;
	}

	public void setPropertyRent(int propertyRent) {
		this.propertyRent = propertyRent;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public float getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(float propertyArea) {
		this.propertyArea = propertyArea;
	}

	public float getPropertyAgencyCommission() {
		return propertyAgencyCommission;
	}

	public void setPropertyAgencyCommission(float propertyAgencyCommission) {
		this.propertyAgencyCommission = propertyAgencyCommission;
	}

	public int getPropertyDeposit() {
		return propertyDeposit;
	}

	public void setPropertyDeposit(int propertyDeposit) {
		this.propertyDeposit = propertyDeposit;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getPropertyLandlordName() {
		return propertyLandlordName;
	}

	public void setPropertyLandlordName(String propertyLandlordName) {
		this.propertyLandlordName = propertyLandlordName;
	}

	public int getPropertyUnitCount() {
		return propertyUnitCount;
	}

	public void setPropertyUnitCount(int propertyUnitCount) {
		this.propertyUnitCount = propertyUnitCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(propertyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertySummary other = (PropertySummary) obj;
		return propertyId == other.propertyId;
	}

	@Override
	public String toString() {
		return "PropertySummary [propertyAgencyCommission=" + propertyAgencyCommission + ", propertyArea=" + propertyArea
				+ ", propertyCity=" + propertyCity + ", propertyDeposit=" + propertyDeposit + ", propertyId=" + propertyId
				+ ", propertyLandlordName=" + propertyLandlordName + ", propertyName=" + propertyName + ", propertyRent="
				+ propertyRent + ", propertyStatus=" + propertyStatus + ", propertyType=" + propertyType
				+ ", propertyUnitCount=" + propertyUnitCount + "]";
	}

}