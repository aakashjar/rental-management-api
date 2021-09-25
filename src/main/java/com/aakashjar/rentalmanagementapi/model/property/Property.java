package com.aakashjar.rentalmanagementapi.model.property;

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
@Table(name = "property")
public class Property {

	@Id
	@Column(name = "property_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_property_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_property_seq", sequenceName = "rms_property_seq")
	private long propertyId;

	@Column(name = "landlord_id")
	private long landlordId;

	@Column(name = "property_name")
	private String propertyName;

	@Column(name = "property_rent")
	private int propertyRent;

	@Column(name = "property_type")
	private String propertyType;

	@Column(name = "property_area")
	private float propertyArea;

	@Column(name = "property_agency_commission")
	private float propertyAgencyCommission;

	@Column(name = "property_deposit")
	private int propertyDeposit;

	@Column(name = "property_description", length = 5000)
	private String propertyDescription;

	@Column(name = "property_address")
	private String propertyAddress;

	@Column(name = "property_city")
	private String propertyCity;

	@Column(name = "property_state")
	private String propertyState;

	@Column(name = "property_pincode")
	private int propertyPincode;

	@Column(name = "property_notes", length = 5000)
	private String propertyNotes;

	@Column(name = "property_age")
	private String propertyAge;

	@Column(name = "property_rooms")
	private int propertyRooms;

	@Column(name = "property_bedrooms")
	private int propertyBedrooms;

	@Column(name = "property_bathrooms")
	private int propertyBathrooms;

	@Column(name = "property_has_air_conditioner")
	private boolean propertyHasAirConditioner;

	@Column(name = "property_has_car_parking")
	private boolean propertyHasCarParking;

	@Column(name = "property_has_laundry_room")
	private boolean propertyHasLaundryRoom;

	@Column(name = "property_has_heating")
	private boolean propertyHasHeating;

	@Column(name = "property_has_balcony")
	private boolean propertyHasBalcony;

	@Column(name = "property_has_gym")
	private boolean propertyHasGym;

	@Column(name = "property_has_internet")
	private boolean propertyHasInternet;

	@Column(name = "property_has_garden")
	private boolean propertyHasGarden;

	@Column(name = "property_has_anti_theft_alarm")
	private boolean propertyHasAntiTheftAlarm;

	@Column(name = "property_has_swimming_pool")
	private boolean propertyHasSwimmingPool;

	@Column(name = "property_has_pets_allowed")
	private boolean propertyHasPetsAllowed;

	@Column(name = "property_has_cctv_cameras")
	private boolean propertyHasCctvCameras;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Property() {
		super();
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

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	public int getPropertyPincode() {
		return propertyPincode;
	}

	public void setPropertyPincode(int propertyPincode) {
		this.propertyPincode = propertyPincode;
	}

	public String getPropertyNotes() {
		return propertyNotes;
	}

	public void setPropertyNotes(String propertyNotes) {
		this.propertyNotes = propertyNotes;
	}

	public String getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(String propertyAge) {
		this.propertyAge = propertyAge;
	}

	public int getPropertyRooms() {
		return propertyRooms;
	}

	public void setPropertyRooms(int propertyRooms) {
		this.propertyRooms = propertyRooms;
	}

	public int getPropertyBedrooms() {
		return propertyBedrooms;
	}

	public void setPropertyBedrooms(int propertyBedrooms) {
		this.propertyBedrooms = propertyBedrooms;
	}

	public int getPropertyBathrooms() {
		return propertyBathrooms;
	}

	public void setPropertyBathrooms(int propertyBathrooms) {
		this.propertyBathrooms = propertyBathrooms;
	}

	public boolean isPropertyHasAirConditioner() {
		return propertyHasAirConditioner;
	}

	public void setPropertyHasAirConditioner(boolean propertyHasAirConditioner) {
		this.propertyHasAirConditioner = propertyHasAirConditioner;
	}

	public boolean isPropertyHasCarParking() {
		return propertyHasCarParking;
	}

	public void setPropertyHasCarParking(boolean propertyHasCarParking) {
		this.propertyHasCarParking = propertyHasCarParking;
	}

	public boolean isPropertyHasLaundryRoom() {
		return propertyHasLaundryRoom;
	}

	public void setPropertyHasLaundryRoom(boolean propertyHasLaundryRoom) {
		this.propertyHasLaundryRoom = propertyHasLaundryRoom;
	}

	public boolean isPropertyHasHeating() {
		return propertyHasHeating;
	}

	public void setPropertyHasHeating(boolean propertyHasHeating) {
		this.propertyHasHeating = propertyHasHeating;
	}

	public boolean isPropertyHasBalcony() {
		return propertyHasBalcony;
	}

	public void setPropertyHasBalcony(boolean propertyHasBalcony) {
		this.propertyHasBalcony = propertyHasBalcony;
	}

	public boolean isPropertyHasGym() {
		return propertyHasGym;
	}

	public void setPropertyHasGym(boolean propertyHasGym) {
		this.propertyHasGym = propertyHasGym;
	}

	public boolean isPropertyHasInternet() {
		return propertyHasInternet;
	}

	public void setPropertyHasInternet(boolean propertyHasInternet) {
		this.propertyHasInternet = propertyHasInternet;
	}

	public boolean isPropertyHasGarden() {
		return propertyHasGarden;
	}

	public void setPropertyHasGarden(boolean propertyHasGarden) {
		this.propertyHasGarden = propertyHasGarden;
	}

	public boolean isPropertyHasAntiTheftAlarm() {
		return propertyHasAntiTheftAlarm;
	}

	public void setPropertyHasAntiTheftAlarm(boolean propertyHasAntiTheftAlarm) {
		this.propertyHasAntiTheftAlarm = propertyHasAntiTheftAlarm;
	}

	public boolean isPropertyHasSwimmingPool() {
		return propertyHasSwimmingPool;
	}

	public void setPropertyHasSwimmingPool(boolean propertyHasSwimmingPool) {
		this.propertyHasSwimmingPool = propertyHasSwimmingPool;
	}

	public boolean isPropertyHasPetsAllowed() {
		return propertyHasPetsAllowed;
	}

	public void setPropertyHasPetsAllowed(boolean propertyHasPetsAllowed) {
		this.propertyHasPetsAllowed = propertyHasPetsAllowed;
	}

	public boolean isPropertyHasCctvCameras() {
		return propertyHasCctvCameras;
	}

	public void setPropertyHasCctvCameras(boolean propertyHasCctvCameras) {
		this.propertyHasCctvCameras = propertyHasCctvCameras;
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
		Property other = (Property) obj;
		return propertyId == other.propertyId;
	}

	@Override
	public String toString() {
		return "Property [createdOn=" + createdOn + ", landlordId=" + landlordId + ", propertyAddress=" + propertyAddress
				+ ", propertyAge=" + propertyAge + ", propertyAgencyCommission=" + propertyAgencyCommission + ", propertyArea="
				+ propertyArea + ", propertyBathrooms=" + propertyBathrooms + ", propertyBedrooms=" + propertyBedrooms
				+ ", propertyCity=" + propertyCity + ", propertyDeposit=" + propertyDeposit + ", propertyDescription="
				+ propertyDescription + ", propertyHasAirConditioner=" + propertyHasAirConditioner
				+ ", propertyHasAntiTheftAlarm=" + propertyHasAntiTheftAlarm + ", propertyHasBalcony=" + propertyHasBalcony
				+ ", propertyHasCarParking=" + propertyHasCarParking + ", propertyHasCctvCameras=" + propertyHasCctvCameras
				+ ", propertyHasGarden=" + propertyHasGarden + ", propertyHasGym=" + propertyHasGym + ", propertyHasHeating="
				+ propertyHasHeating + ", propertyHasInternet=" + propertyHasInternet + ", propertyHasLaundryRoom="
				+ propertyHasLaundryRoom + ", propertyHasPetsAllowed=" + propertyHasPetsAllowed + ", propertyHasSwimmingPool="
				+ propertyHasSwimmingPool + ", propertyId=" + propertyId + ", propertyName=" + propertyName + ", propertyNotes="
				+ propertyNotes + ", propertyPincode=" + propertyPincode + ", propertyRent=" + propertyRent + ", propertyRooms="
				+ propertyRooms + ", propertyState=" + propertyState + ", propertyType=" + propertyType + ", updatedOn="
				+ updatedOn + "]";
	}

}
