package com.pack.exception;

public class NoSufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSufficientBalanceException(String message) 
	{
		super(message);
	}
}
