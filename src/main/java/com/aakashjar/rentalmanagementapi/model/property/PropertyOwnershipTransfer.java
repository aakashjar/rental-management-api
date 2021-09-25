package com.aakashjar.rentalmanagementapi.model.property;

import java.util.Objects;

public class PropertyOwnershipTransfer {

	private long propertyId;

	private long landlordId;

	public PropertyOwnershipTransfer() {
		super();
	}

	public PropertyOwnershipTransfer(long propertyId, long landlordId) {
		this.propertyId = propertyId;
		this.landlordId = landlordId;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public long getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(long landlordId) {
		this.landlordId = landlordId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(landlordId, propertyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyOwnershipTransfer other = (PropertyOwnershipTransfer) obj;
		return landlordId == other.landlordId && propertyId == other.propertyId;
	}

	@Override
	public String toString() {
		return "PropertyOwnershipTransfer [landlordId=" + landlordId + ", propertyId=" + propertyId + "]";
	}

}
