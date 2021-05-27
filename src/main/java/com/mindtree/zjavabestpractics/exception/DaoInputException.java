package com.mindtree.zjavabestpractics.exception;

public class DaoInputException extends Exception {

	public DaoInputException() {
		
	}

	public DaoInputException(String message) {
		super(message);
	
	}

	public DaoInputException(Throwable cause) {
		super(cause);
	
	}

	public DaoInputException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DaoInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
