package com.exception;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015��7��29������4:37:46
 *
 * @version 1.0.0
 */
public class MissingValueException extends RuntimeException{

	private static final long serialVersionUID = -2884743473967800569L;
	
	public MissingValueException(String message) {
		super(message);
	}


}
