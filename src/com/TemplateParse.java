package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.PlainText;
import com.model.Segment;
import com.model.Variable;

public class TemplateParse {

	public List<String> parse(String template) {
		List<String> segments = new ArrayList<>();
		int index = collectSegments(segments,template);
		addTail(segments,template,index);
		addEmptyStringIfTemplateIsEmpty(segments);
		return segments;
	}

	private void addEmptyStringIfTemplateIsEmpty(List<String> segments) {
		if(segments.isEmpty()){
			segments.add("");
		}
	}

	private void addTail(List<String> segments, String template, int index) {
		//如果末尾还有纯文本附加上
		if(index<template.length()){
			segments.add(template.substring(index));
		}
	}

	private int collectSegments(List<String> segments, String template) {
		String regex = "\\$\\{[^}]*\\}";
		Matcher matcher = Pattern.compile(regex).matcher(template);
		int index = 0;
		while(matcher.find()){
			addPrecedingPlainText(segments,template,matcher,index);
			addVariables(segments,template,matcher);
			index = matcher.end();
		}
		return index;
	}

	private void addVariables(List<String> segments, String template, Matcher matcher) {
		segments.add(template.substring(matcher.start(),matcher.end()));
	}

	private void addPrecedingPlainText(List<String> segments, String template, Matcher matcher, int index) {
		if(index!=matcher.start()){
			segments.add(template.substring(index,matcher.start()));
		}
	}

	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<>();
		List<String> result = parse(template);
		for(String value:result){
			if(isVariable(value)){
				String name = value.substring(2,value.length()-1);
				segments.add(new Variable(name));
			}else{
				segments.add(new PlainText(value));
			}
		}
		return segments;
	}
	
	private boolean isVariable(String segment) {
		return segment.startsWith("${")&&segment.endsWith("}");
	}
}

