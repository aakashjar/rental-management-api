package com.aakashjar.rentalmanagementapi.payload;

import java.util.Objects;

public class LandlordSummary {

	private long landlordId;
	private String landlordFullName;
	private String landlordEmailAddress;
	private String landlordMobileNumber;
	private int landlordPropertyCount;
	private int landlordPropertyUnitCount;

	public LandlordSummary() {
		super();
	}

	public LandlordSummary(long landlordId, String landlordFullName, String landlordEmailAddress,
			String landlordMobileNumber, int landlordPropertyCount, int landlordPropertyUnitCount) {
		this.landlordId = landlordId;
		this.landlordFullName = landlordFullName;
		this.landlordEmailAddress = landlordEmailAddress;
		this.landlordMobileNumber = landlordMobileNumber;
		this.landlordPropertyCount = landlordPropertyCount;
		this.landlordPropertyUnitCount = landlordPropertyUnitCount;
	}

	public long getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(long landlordId) {
		this.landlordId = landlordId;
	}

	public String getLandlordFullName() {
		return landlordFullName;
	}

	public void setLandlordFullName(String landlordFullName) {
		this.landlordFullName = landlordFullName;
	}

	public String getLandlordEmailAddress() {
		return landlordEmailAddress;
	}

	public void setLandlordEmailAddress(String landlordEmailAddress) {
		this.landlordEmailAddress = landlordEmailAddress;
	}

	public String getLandlordMobileNumber() {
		return landlordMobileNumber;
	}

	public void setLandlordMobileNumber(String landlordMobileNumber) {
		this.landlordMobileNumber = landlordMobileNumber;
	}

	public int getLandlordPropertyCount() {
		return landlordPropertyCount;
	}

	public void setLandlordPropertyCount(int landlordPropertyCount) {
		this.landlordPropertyCount = landlordPropertyCount;
	}

	public int getLandlordPropertyUnitCount() {
		return landlordPropertyUnitCount;
	}

	public void setLandlordPropertyUnitCount(int landlordPropertyUnitCount) {
		this.landlordPropertyUnitCount = landlordPropertyUnitCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(landlordId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LandlordSummary other = (LandlordSummary) obj;
		return landlordId == other.landlordId;
	}

	@Override
	public String toString() {
		return "LandlordSummary [landlordEmailAddress=" + landlordEmailAddress + ", landlordFullName=" + landlordFullName
				+ ", landlordId=" + landlordId + ", landlordMobileNumber=" + landlordMobileNumber + ", landlordPropertyCount="
				+ landlordPropertyCount + ", landlordPropertyUnitCount=" + landlordPropertyUnitCount + "]";
	}

}
