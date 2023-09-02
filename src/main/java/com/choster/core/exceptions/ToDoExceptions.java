package com.choster.core.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;

@Data

public class ToDoExceptions extends RuntimeException{
	
	private String message;
	private HttpStatus httpStatus;
	
	public ToDoExceptions(String message,HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	
	
}
