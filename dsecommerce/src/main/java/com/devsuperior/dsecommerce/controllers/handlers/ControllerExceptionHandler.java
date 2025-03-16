package com.devsuperior.dsecommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dsecommerce.dto.CustomError;
import com.devsuperior.dsecommerce.services.exception.DatabaseException;
import com.devsuperior.dsecommerce.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest httpStatus) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), httpStatus.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
