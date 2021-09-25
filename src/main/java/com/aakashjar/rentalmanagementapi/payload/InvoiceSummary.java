package com.aakashjar.rentalmanagementapi.payload;

import java.time.LocalDate;
import java.util.Objects;

import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.model.lease.Lease;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;

public class InvoiceSummary {

	private long invoiceId;
	private Lease leaseDetail;
	private Tenant tenantDetail;
	private Landlord landlordDetail;
	private Property propertyDetail;
	private PropertyUnit propertyUnitDetail;
	private LocalDate invoicePeriod;
	private LocalDate invoiceDueDate;
	private int invoiceAmount;
	private char invoiceStatus;

	public InvoiceSummary() {
		super();
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Lease getLeaseDetail() {
		return leaseDetail;
	}

	public void setLeaseDetail(Lease leaseDetail) {
		this.leaseDetail = leaseDetail;
	}

	public Tenant getTenantDetail() {
		return tenantDetail;
	}

	public void setTenantDetail(Tenant tenantDetail) {
		this.tenantDetail = tenantDetail;
	}

	public Landlord getLandlordDetail() {
		return landlordDetail;
	}

	public void setLandlordDetail(Landlord landlordDetail) {
		this.landlordDetail = landlordDetail;
	}

	public Property getPropertyDetail() {
		return propertyDetail;
	}

	public void setPropertyDetail(Property propertyDetail) {
		this.propertyDetail = propertyDetail;
	}

	public PropertyUnit getPropertyUnitDetail() {
		return propertyUnitDetail;
	}

	public void setPropertyUnitDetail(PropertyUnit propertyUnitDetail) {
		this.propertyUnitDetail = propertyUnitDetail;
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
		InvoiceSummary other = (InvoiceSummary) obj;
		return invoiceId == other.invoiceId;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [invoiceAmount=" + invoiceAmount + ", invoiceDueDate=" + invoiceDueDate + ", invoiceId="
				+ invoiceId + ", invoicePeriod=" + invoicePeriod + ", invoiceStatus=" + invoiceStatus + ", landlordDetail="
				+ landlordDetail + ", leaseDetail=" + leaseDetail + ", propertyDetail=" + propertyDetail
				+ ", propertyUnitDetail=" + propertyUnitDetail + ", tenantDetail=" + tenantDetail + "]";
	}

}
