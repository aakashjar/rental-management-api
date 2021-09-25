package com.aakashjar.rentalmanagementapi.model.inventory;

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
@Table(name = "inventory")
public class Inventory {

	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_inventory_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_inventory_seq", sequenceName = "rms_inventory_seq")
	private long inventoryId;

	@Column(name = "property_id")
	private long propertyId;

	@Column(name = "property_unit_id")
	private long propertyUnitId;

	@Column(name = "inventory_description", length = 5000)
	private String inventoryDescription;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Inventory() {
		super();
	}

	public long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
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

	public String getInventoryDescription() {
		return inventoryDescription;
	}

	public void setInventoryDescription(String inventoryDescription) {
		this.inventoryDescription = inventoryDescription;
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
		return Objects.hash(inventoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return inventoryId == other.inventoryId;
	}

	@Override
	public String toString() {
		return "Inventory [createdOn=" + createdOn + ", inventoryDescription=" + inventoryDescription + ", inventoryId="
				+ inventoryId + ", propertyId=" + propertyId + ", propertyUnitId=" + propertyUnitId + ", updatedOn=" + updatedOn
				+ "]";
	}

}
