package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource not found on server !!");
		// TODO Auto-generated constructor stub
	}
	
	public ResourceNotFoundException(String ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}
	
	

}
