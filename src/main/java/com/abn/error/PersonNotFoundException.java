package com.abn.error;

public class PersonNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(int Id) {
		super("Person id not found : " + Id);
	}

}
