package com.cg.exception;

public class InvalidContactNumberException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public InvalidContactNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvalidContactNumberException(final String message) {
		super(message);
		
	}
	
}
