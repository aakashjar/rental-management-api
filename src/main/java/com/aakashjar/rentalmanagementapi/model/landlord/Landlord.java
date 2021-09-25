package com.aakashjar.rentalmanagementapi.model.landlord;

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
@Table(name = "landlord")
public class Landlord {

	@Id
	@Column(name = "landlord_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_landlord_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_landlord_seq", sequenceName = "rms_landlord_seq")
	private long landlordId;

	@Column(name = "landlord_full_name")
	private String landlordFullName;

	@Column(name = "landlord_email_address")
	private String landlordEmailAddress;

	@Column(name = "landlord_mobile_number")
	private String landlordMobileNumber;

	@Column(name = "landlord_identity_no")
	private String landlordIdentityNumber;

	@Column(name = "landlord_address")
	private String landlordAddress;

	@Column(name = "landlord_bank_name")
	private String landlordBankName;

	@Column(name = "landlord_bank_account_number")
	private long landlordBankAccountNumber;

	@Column(name = "landlord_bank_ifsc")
	private String landlordBankIfsc;

	@Column(name = "landlord_emergency_contact_name")
	private String landlordEmergencyContactName;

	@Column(name = "landlord_emergency_contact_mobile_number")
	private String landlordEmergencyContactMobileNumber;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Landlord() {
		super();
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

	public String getLandlordIdentityNumber() {
		return landlordIdentityNumber;
	}

	public void setLandlordIdentityNumber(String landlordIdentityNumber) {
		this.landlordIdentityNumber = landlordIdentityNumber;
	}

	public String getLandlordAddress() {
		return landlordAddress;
	}

	public void setLandlordAddress(String landlordAddress) {
		this.landlordAddress = landlordAddress;
	}

	public String getLandlordBankName() {
		return landlordBankName;
	}

	public void setLandlordBankName(String landlordBankName) {
		this.landlordBankName = landlordBankName;
	}

	public long getLandlordBankAccountNumber() {
		return landlordBankAccountNumber;
	}

	public void setLandlordBankAccountNumber(long landlordBankAccountNumber) {
		this.landlordBankAccountNumber = landlordBankAccountNumber;
	}

	public String getLandlordBankIfsc() {
		return landlordBankIfsc;
	}

	public void setLandlordBankIfsc(String landlordBankIfsc) {
		this.landlordBankIfsc = landlordBankIfsc;
	}

	public String getLandlordEmergencyContactName() {
		return landlordEmergencyContactName;
	}

	public void setLandlordEmergencyContactName(String landlordEmergencyContactName) {
		this.landlordEmergencyContactName = landlordEmergencyContactName;
	}

	public String getLandlordEmergencyContactMobileNumber() {
		return landlordEmergencyContactMobileNumber;
	}

	public void setLandlordEmergencyContactMobileNumber(String landlordEmergencyContactMobileNumber) {
		this.landlordEmergencyContactMobileNumber = landlordEmergencyContactMobileNumber;
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
		Landlord other = (Landlord) obj;
		return landlordId == other.landlordId;
	}

	@Override
	public String toString() {
		return "Landlord [createdOn=" + createdOn + ", landlordAddress=" + landlordAddress + ", landlordBankAccountNumber="
				+ landlordBankAccountNumber + ", landlordBankIfsc=" + landlordBankIfsc + ", landlordBankName="
				+ landlordBankName + ", landlordEmailAddress=" + landlordEmailAddress
				+ ", landlordEmergencyContactMobileNumber=" + landlordEmergencyContactMobileNumber
				+ ", landlordEmergencyContactName=" + landlordEmergencyContactName + ", landlordFullName=" + landlordFullName
				+ ", landlordId=" + landlordId + ", landlordIdentityNumber=" + landlordIdentityNumber
				+ ", landlordMobileNumber=" + landlordMobileNumber + ", updatedOn=" + updatedOn + "]";
	}

}
