package com.ceiba.exception;

public class ExceptionNoMayorCero extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ExceptionNoMayorCero(String message) {
        super(message);
    }
}
