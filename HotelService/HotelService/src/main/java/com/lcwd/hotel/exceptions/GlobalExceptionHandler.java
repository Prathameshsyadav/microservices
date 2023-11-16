package com.lcwd.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Apipayload> handlerResourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		Apipayload response = new Apipayload(message,true);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
