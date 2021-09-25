package com.aakashjar.rentalmanagementapi.service.invoice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aakashjar.rentalmanagementapi.dao.invoice.InvoiceDAO;
import com.aakashjar.rentalmanagementapi.dao.landlord.LandlordDAO;
import com.aakashjar.rentalmanagementapi.dao.lease.LeaseDAO;
import com.aakashjar.rentalmanagementapi.dao.property.PropertyDAO;
import com.aakashjar.rentalmanagementapi.dao.propertyunit.PropertyUnitDAO;
import com.aakashjar.rentalmanagementapi.dao.tenant.TenantDAO;
import com.aakashjar.rentalmanagementapi.model.invoice.Invoice;
import com.aakashjar.rentalmanagementapi.model.landlord.Landlord;
import com.aakashjar.rentalmanagementapi.model.lease.Lease;
import com.aakashjar.rentalmanagementapi.model.property.Property;
import com.aakashjar.rentalmanagementapi.model.propertyunit.PropertyUnit;
import com.aakashjar.rentalmanagementapi.model.tenant.Tenant;
import com.aakashjar.rentalmanagementapi.payload.InvoiceSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceDAO invoiceDAO;

	@Autowired
	private TenantDAO tenantDAO;

	@Autowired
	private LeaseDAO leaseDAO;

	@Autowired
	private PropertyUnitDAO propertyUnitDAO;

	@Autowired
	private PropertyDAO propertyDAO;

	@Autowired
	private LandlordDAO landlordDAO;

	public void createInvoice(Invoice invoice) {
		invoiceDAO.save(invoice);
	}

	public void deleteInvoice(Invoice invoice) {
		invoiceDAO.delete(invoice);
	}

	public long deleteInvoiceByLease(long leaseId) {
		return invoiceDAO.deleteByLeaseIdAndInvoiceStatus(leaseId, 'U');
	}

	public List<Object[]> getInvoicesByMonth() {
		return invoiceDAO.findInvoicesByMonth();
	}

	public List<InvoiceSummary> getInvoiceSummaryList() {

		List<InvoiceSummary> invoiceSummaryList = new ArrayList<>();

		List<Invoice> currentInvoiceList = (List<Invoice>) invoiceDAO.findAll();

		currentInvoiceList.forEach(currentInvoice -> {

			InvoiceSummary currentInvoiceSummaryData = new InvoiceSummary();

			currentInvoiceSummaryData.setInvoiceId(currentInvoice.getInvoiceId());

			Optional<Lease> currentLeaseOptional = leaseDAO.findById(currentInvoice.getLeaseId());

			if (currentLeaseOptional.isPresent()) {
				currentInvoiceSummaryData.setLeaseDetail(currentLeaseOptional.get());
			}

			Optional<Tenant> currentTenantOptional = tenantDAO.findById(currentLeaseOptional.get().getTenantId());

			if (currentTenantOptional.isPresent()) {
				currentInvoiceSummaryData.setTenantDetail(currentTenantOptional.get());
			}

			Optional<Property> currentPropertyOptional = propertyDAO.findById(currentLeaseOptional.get().getPropertyId());

			if (currentPropertyOptional.isPresent()) {
				currentInvoiceSummaryData.setPropertyDetail(currentPropertyOptional.get());
			}

			if (currentLeaseOptional.get().getPropertyUnitId() > 0) {
				Optional<PropertyUnit> currentPropertyUnitOptional = propertyUnitDAO
						.findById(currentLeaseOptional.get().getPropertyUnitId());

				currentInvoiceSummaryData.setPropertyUnitDetail(currentPropertyUnitOptional.get());
			} else {
				currentInvoiceSummaryData.setPropertyUnitDetail(new PropertyUnit());
			}

			Optional<Landlord> currentLandlordOptional = landlordDAO.findById(currentPropertyOptional.get().getLandlordId());

			if (currentLandlordOptional.isPresent()) {
				currentInvoiceSummaryData.setLandlordDetail(currentLandlordOptional.get());
			}

			currentInvoiceSummaryData.setInvoiceAmount(currentInvoice.getInvoiceAmount());
			currentInvoiceSummaryData.setInvoicePeriod(currentInvoice.getInvoicePeriod());
			currentInvoiceSummaryData.setInvoiceDueDate(currentInvoice.getInvoiceDueDate());
			currentInvoiceSummaryData.setInvoiceStatus(currentInvoice.getInvoiceStatus());

			invoiceSummaryList.add(currentInvoiceSummaryData);
		});

		return invoiceSummaryList;
	}

	public boolean payInvoice(Long invoiceId) {
		if (invoiceId > 0) {
			Optional<Invoice> currentInvoiceOptional = invoiceDAO.findById(invoiceId);

			if (currentInvoiceOptional.isPresent()) {
				Invoice currentInvoice = currentInvoiceOptional.get();

				currentInvoice.setInvoiceStatus('P');
				currentInvoice.setUpdatedOn(LocalDateTime.now());
				invoiceDAO.save(currentInvoice);

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
