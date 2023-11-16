package com.lcwd.user.service.exceptions;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	String message;
	boolean success;
	HttpStatus status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", success=" + success + ", status=" + status + "]";
	}
	
	
	
}
