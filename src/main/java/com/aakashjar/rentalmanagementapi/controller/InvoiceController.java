package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.InvoiceSummary;
import com.aakashjar.rentalmanagementapi.service.invoice.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/month/list")
	public ResponseEntity<List<Object[]>> getInventoryList() {
		return ResponseEntity.ok(invoiceService.getInvoicesByMonth());
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<InvoiceSummary>> getInvoiceSummaryList() {
		return ResponseEntity.ok(invoiceService.getInvoiceSummaryList());
	}

	@PostMapping("/pay/{invoiceId}")
	public ResponseEntity<ApiResponse> payInvoice(@PathVariable("invoiceId") Long invoiceId) {
		boolean status = invoiceService.payInvoice(invoiceId);
		return ResponseEntity.status(status ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(status, status ? "Invoice payment successful!" : "Invoice payment failed!"));
	}
}
