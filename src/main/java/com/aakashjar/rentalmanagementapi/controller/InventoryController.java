package com.aakashjar.rentalmanagementapi.controller;

import java.util.List;

import com.aakashjar.rentalmanagementapi.model.inventory.Inventory;
import com.aakashjar.rentalmanagementapi.payload.ApiResponse;
import com.aakashjar.rentalmanagementapi.payload.InventorySummary;
import com.aakashjar.rentalmanagementapi.service.inventory.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> registerInventory(@RequestBody Inventory inventory) {
		return inventoryService.registerInventory(inventory);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Inventory>> getInventoryList() {
		return inventoryService.getInventoryList();
	}

	@GetMapping("/summary/list")
	public ResponseEntity<List<InventorySummary>> getInventorySummaryList() {
		return inventoryService.getInventorySummaryList();
	}

	@GetMapping("/{inventoryId}")
	public ResponseEntity<?> getInventory(@PathVariable("inventoryId") Long inventoryId) {
		return inventoryService.getInventoryData(inventoryId);
	}

	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateInventory(@RequestBody Inventory inventory) {
		return inventoryService.updateInventoryData(inventory);
	}

	@DeleteMapping("/{inventoryId}")
	public ResponseEntity<ApiResponse> deleteInventory(@PathVariable("inventoryId") Long inventoryId) {
		return inventoryService.deleteInventoryData(inventoryId);
	}
}
