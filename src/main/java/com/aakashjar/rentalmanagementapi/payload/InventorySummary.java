package com.aakashjar.rentalmanagementapi.payload;

import java.time.LocalDateTime;
import java.util.Objects;

public class InventorySummary {

	private long inventoryId;
	private String inventoryForName;
	private String inventoryForType;
	private long propertyId;
	private long propertyUnitId;
	private String inventoryDescription;
	private LocalDateTime createdOn;

	public InventorySummary() {
		super();
	}

	public InventorySummary(long inventoryId, String inventoryForName, String inventoryForType, long propertyId,
			long propertyUnitId, String inventoryDescription, LocalDateTime createdOn) {
		this.inventoryId = inventoryId;
		this.inventoryForName = inventoryForName;
		this.inventoryForType = inventoryForType;
		this.propertyId = propertyId;
		this.propertyUnitId = propertyUnitId;
		this.inventoryDescription = inventoryDescription;
		this.createdOn = createdOn;
	}

	public long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryForName() {
		return inventoryForName;
	}

	public void setInventoryForName(String inventoryForName) {
		this.inventoryForName = inventoryForName;
	}

	public String getInventoryForType() {
		return inventoryForType;
	}

	public void setInventoryForType(String inventoryForType) {
		this.inventoryForType = inventoryForType;
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
		InventorySummary other = (InventorySummary) obj;
		return inventoryId == other.inventoryId;
	}

	@Override
	public String toString() {
		return "InventorySummary [createdOn=" + createdOn + ", inventoryDescription=" + inventoryDescription
				+ ", inventoryForName=" + inventoryForName + ", inventoryForType=" + inventoryForType + ", inventoryId="
				+ inventoryId + ", propertyId=" + propertyId + ", propertyUnitId=" + propertyUnitId + "]";
	}

}
