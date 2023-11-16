package com.lcwd.hotel.exceptions;

public class Apipayload {
	
	String message;
	boolean status;
	public Apipayload(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public Apipayload() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	

}
