package com.aakashjar.rentalmanagementapi.model.propertyunit;

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
@Table(name = "property_unit")
public class PropertyUnit {

	@Id
	@Column(name = "property_unit_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_property_unit_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_property_unit_seq", sequenceName = "rms_property_unit_seq")
	private long propertyUnitId;

	@Column(name = "property_id")
	private long propertyId;

	@Column(name = "property_unit_name")
	private String propertyUnitName;

	@Column(name = "property_unit_agency_commission")
	private float propertyUnitAgencyCommission;

	@Column(name = "property_unit_rent")
	private int propertyUnitRent;

	@Column(name = "property_unit_deposit")
	private int propertyUnitDeposit;

	@Column(name = "property_unit_summary", length = 5000)
	private String propertyUnitSummary;

	@Column(name = "property_unit_Description", length = 5000)
	private String propertyUnitDescription;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public PropertyUnit() {
		super();
	}

	public long getPropertyUnitId() {
		return propertyUnitId;
	}

	public void setPropertyUnitId(long propertyUnitId) {
		this.propertyUnitId = propertyUnitId;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyUnitName() {
		return propertyUnitName;
	}

	public void setPropertyUnitName(String propertyUnitName) {
		this.propertyUnitName = propertyUnitName;
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

	public String getPropertyUnitSummary() {
		return propertyUnitSummary;
	}

	public void setPropertyUnitSummary(String propertyUnitSummary) {
		this.propertyUnitSummary = propertyUnitSummary;
	}

	public String getPropertyUnitDescription() {
		return propertyUnitDescription;
	}

	public void setPropertyUnitDescription(String propertyUnitDescription) {
		this.propertyUnitDescription = propertyUnitDescription;
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
		PropertyUnit other = (PropertyUnit) obj;
		return propertyUnitId == other.propertyUnitId;
	}

	@Override
	public String toString() {
		return "PropertyUnit [createdOn=" + createdOn + ", propertyId=" + propertyId + ", propertyUnitAgencyCommission="
				+ propertyUnitAgencyCommission + ", propertyUnitDeposit=" + propertyUnitDeposit + ", propertyUnitDescription="
				+ propertyUnitDescription + ", propertyUnitId=" + propertyUnitId + ", propertyUnitName=" + propertyUnitName
				+ ", propertyUnitRent=" + propertyUnitRent + ", propertyUnitSummary=" + propertyUnitSummary + ", updatedOn="
				+ updatedOn + "]";
	}

}