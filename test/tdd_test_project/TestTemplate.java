package tdd_test_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Template;
import com.exception.MissingValueException;
public class TestTemplate {
	Template template;
	@Before
	public void init(){
		template = new Template("${one},${two},${three}");
		template.put("one","1");
		template.put("two","2");
		template.put("three","3");
	}
	
	@Test
	public void multipleVariable(){
		assertTemplateEvaluatesTo("1,2,3");
	}
	
	@Test
	public void unknowVariableAreIgnored(){
		template.put("notexist","2");
		assertTemplateEvaluatesTo("1,2,3");
	}
	
	private void assertTemplateEvaluatesTo(String expect){
		assertEquals(expect, template.evalute());
	}
	
	@Test
	public void missingValueException(){
		template = new Template("${foo}");
		try{
			template.evalute();
			fail("evalue() should throw an exception if a variable left without a value");
		}catch(MissingValueException e){
			e.printStackTrace();
			assertEquals("No value for ${foo}", e.getMessage());
		}
	}
	
	@Test
	public void variablesGetProcessedJustOnce()throws Exception{
		template.put("one","${one}");
		template.put("two", "${three}");
		template.put("three", "${two}");
		template.evalute();
		assertTemplateEvaluatesTo("${one},${three},${two}");
	}
}
