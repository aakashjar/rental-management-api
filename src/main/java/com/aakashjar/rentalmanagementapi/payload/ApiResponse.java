package com.aakashjar.rentalmanagementapi.payload;

import java.time.ZonedDateTime;

public class ApiResponse {

	private Boolean success;
	private String message;
	private ZonedDateTime timestamp;

	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
		this.timestamp = ZonedDateTime.now();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
