package com.devsuperior.dsecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError  {

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Instant instant, int status, String error, String path) {
		super(instant, status, error, path);
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	
}
