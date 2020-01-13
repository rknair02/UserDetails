package com.abn.error;

public class EmailNotvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailNotvalidException(String string) {
		super("Email entered is not valid : " + string);
	}

}
