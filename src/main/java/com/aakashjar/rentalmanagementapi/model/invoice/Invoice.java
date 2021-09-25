package com.aakashjar.rentalmanagementapi.model.invoice;

import java.time.LocalDate;
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
@Table(name = "invoice")
public class Invoice {

	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rms_invoice_seq")
	@SequenceGenerator(allocationSize = 1, name = "rms_invoice_seq", sequenceName = "rms_invoice_seq")
	private long invoiceId;

	@Column(name = "lease_id")
	private long leaseId;

	@Column(name = "invoice_period")
	private LocalDate invoicePeriod;

	@Column(name = "invoice_due_date")
	private LocalDate invoiceDueDate;

	@Column(name = "invoice_amount")
	private int invoiceAmount;

	@Column(name = "invoice_status")
	private char invoiceStatus;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	public Invoice() {
		super();
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(long leaseId) {
		this.leaseId = leaseId;
	}

	public LocalDate getInvoicePeriod() {
		return invoicePeriod;
	}

	public void setInvoicePeriod(LocalDate invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public LocalDate getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(LocalDate invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}

	public int getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(int invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public char getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(char invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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
		return Objects.hash(invoiceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return invoiceId == other.invoiceId;
	}

	@Override
	public String toString() {
		return "Invoice [createdOn=" + createdOn + ", invoiceAmount=" + invoiceAmount + ", invoiceDueDate=" + invoiceDueDate
				+ ", invoiceId=" + invoiceId + ", invoicePeriod=" + invoicePeriod + ", invoiceStatus=" + invoiceStatus
				+ ", leaseId=" + leaseId + ", updatedOn=" + updatedOn + "]";
	}

}