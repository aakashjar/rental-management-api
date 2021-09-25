package com.aakashjar.rentalmanagementapi.model.bill;

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
@Table(name = "bill")
public class Bill {

	@Id
	@Column(name = "bill_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_bill_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_bill_seq", sequenceName = "rms_bill_seq")
	private long billId;

	@Column(name = "lease_id")
	private long leaseId;

	@Column(name = "bill_name")
	private String billName;

	@Column(name = "bill_amount")
	private float billAmount;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Bill() {
		super();
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public long getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(long leaseId) {
		this.leaseId = leaseId;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
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
		return Objects.hash(billId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return billId == other.billId;
	}

	@Override
	public String toString() {
		return "Bill [billAmount=" + billAmount + ", billId=" + billId + ", billName=" + billName + ", createdOn="
				+ createdOn + ", leaseId=" + leaseId + ", updatedOn=" + updatedOn + "]";
	}

}
