package com.lcwd.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource not found on server!!!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
