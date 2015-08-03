package tdd_test_project;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.TemplateParse;

public class TestTemplateParse {
	@Test
	public void emptyTemplateRendersAsEmptyString(){
		List<String> segments = parse(" ");
		assertSegments(segments, " ");
	}
	
	@Test
	public void templateWithOnlyPlainText(){
		List<String> segments = parse("plain text only");
		assertSegments(segments, "plain text only");
	}

	private List<String> parse(String template) {
		// TODO Auto-generated method stub
		return new TemplateParse().parse(template);
	}
	
	private void assertSegments(List<? extends Object> actual,Object... expected){
		assertEquals("Number of segments doesn't match",expected.length,actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}
	@Test
	public void parseMultipleVariables(){
		List<String> segments = parse("{a}:{b}:dsflsdf{bd}");
		assertSegments(segments, "{a}",":","{b}",":dsflsdf","{bd}");
	}
}
