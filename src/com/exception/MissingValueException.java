package com.exception;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015年7月29日下午4:37:46
 *
 * @version 1.0.0
 */
public class MissingValueException extends RuntimeException{

	private static final long serialVersionUID = -2884743473967800569L;
	
	public MissingValueException(String message) {
		super(message);
	}


}
