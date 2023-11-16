package com.lcwd.ratingservices.exceptions;

public class ApiPayload {
	
	String message;
	boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ApiPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiPayload(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	

}
