package com.mindtree.zjavabestpractics.exception;

public class DaoOutputException extends Exception {

	public DaoOutputException() {
		
	}

	public DaoOutputException(String message) {
		super(message);
		
	}

	public DaoOutputException(Throwable cause) {
		super(cause);
	
	}

	public DaoOutputException(String message, Throwable cause) {
		super(message, cause);

	}

	public DaoOutputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
