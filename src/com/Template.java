/**
 * 
 */
package com;

import java.util.HashMap;
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
		String result = replaceVariables();
		checkMissingValues(result);
		return result;
	}

	private String replaceVariables() {
		String result = templateText;
		for(Entry<String,String> entry:variables.entrySet()){
			String regex = "\\$\\{"+entry.getKey()+"\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}

	private void checkMissingValues(String result) {
		Matcher m = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
		if(m.find()){
			throw new MissingValueException("No value for " + m.group());
		}
	}
}
