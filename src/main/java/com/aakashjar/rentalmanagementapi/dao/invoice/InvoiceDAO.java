package com.aakashjar.rentalmanagementapi.dao.invoice;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.invoice.Invoice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InvoiceDAO extends CrudRepository<Invoice, Long> {

	@Query(nativeQuery = true, value = "select to_char(invoice_period,'Mon YYYY') invoice_period, count(*), sum(invoice_amount) from invoice where invoice_status = 'U' group by invoice_period")
	List<Object[]> findInvoicesByMonth();

	long deleteByLeaseIdAndInvoiceStatus(long leaseId, char invoiceStatus);
}
