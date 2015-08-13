package com.model;

import java.util.Map;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015年8月13日下午4:30:18
 *
 * @version 1.0.0
 */
public interface Segment {
	
	public String evaluate(Map<String, String> variable);
}
