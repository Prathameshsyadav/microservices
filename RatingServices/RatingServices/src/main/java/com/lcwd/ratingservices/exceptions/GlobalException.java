package com.lcwd.ratingservices.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public HttpEntity<ApiPayload> handlerResourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiPayload response = new ApiPayload(message,true);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
