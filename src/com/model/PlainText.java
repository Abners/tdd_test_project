package com.model;

import java.util.Map;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015年8月13日下午4:31:07
 *
 * @version 1.0.0
 */
public class PlainText implements Segment {
	private String text;
	public PlainText(String text){
		this.text = text;
	}
	
	@Override
	public boolean equals(Object other){
		return text.equals(((PlainText)other).text);
	}

	@Override
	public String evaluate(Map<String, String> variable) {
		return text;
	}
}
