/**
 * 
 */
package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exception.MissingValueException;
import com.model.Segment;

/**
 * @author Administrator
 *
 */
public class Template {
	
	private Map<String,String> variables;
	private String templateText;
	public Template(String templateText) {
		this.variables = new HashMap<>();
		this.templateText = templateText;
	}

	public Template() {
		// TODO Auto-generated constructor stub
	}

	public void put(String variable, String value) {
		// TODO Auto-generated method stub
		variables.put(variable, value);
	}

	public String evalute() {
		TemplateParse parse = new TemplateParse();
		List<Segment> segments = parse.parseSegments(templateText);
		return concatenate(segments);
	}

	private String concatenate(List<Segment> segments) {
		StringBuilder result = new StringBuilder();
		for(Segment segment:segments){
			result.append(segment.evaluate(variables));
		}
		return result.toString();
	}
}
