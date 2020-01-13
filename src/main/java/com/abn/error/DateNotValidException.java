package com.abn.error;

public class DateNotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateNotValidException(String date) {
		super("Please enter the date in correct format mm/dd/yyyy " + date);
	}
}
