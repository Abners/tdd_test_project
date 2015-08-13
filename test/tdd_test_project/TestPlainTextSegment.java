package tdd_test_project;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.model.PlainText;

public class TestPlainTextSegment {
	
	@Test
	public void plainTextEvaluatesAsIs(){
		Map<String,String> variables = new HashMap<>();
		String text = "abc def";
		assertEquals(text,new PlainText(text).evaluate(variables));
	}
}
