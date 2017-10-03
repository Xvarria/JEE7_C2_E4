package com.empresa.math.server;

public class FibException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param string
	 * @param string2
	 */
	public FibException(String str1, String str2) {
		super("FibonacciExc: [" + str1 + " " + str2 + "]");
	}

	

}
