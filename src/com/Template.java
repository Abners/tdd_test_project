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
		List<String> segments = parse.parse(templateText);
		return concatenate(segments);
	}

	private String concatenate(List<String> segments) {
		StringBuilder result = new StringBuilder();
		for(String segment:segments){
			append(result,segment);
		}
		return result.toString();
	}

	private void append(StringBuilder result, String segment) {
		if(isVariable(segment)){
			evaluateVariable(result, segment);
		}else{
			result.append(segment);
		}
	}

	private void evaluateVariable(StringBuilder result, String segment) {
		String var = segment.substring(2, segment.length()-1);
		if(!variables.containsKey(var)){
			throw new MissingValueException("No value for "+segment);
		}
		result.append(variables.get(var));
	}

	private boolean isVariable(String segment) {
		return segment.startsWith("${")&&segment.endsWith("}");
	}
}
