package tdd_test_project;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.exception.MissingValueException;
import com.model.Variable;

public class TestVariableSegment {
	Map<String,String> variable;
	@Before
	public void init(){
		variable = new HashMap<>();
	}
	@Test
	public void testVariableEvaluatesToItsValue(){
		String name = "myvar";
		String value = "myvalue";
		variable.put(name, value);
		assertEquals(value,new Variable(name).evaluate(variable));
		
	}
	@Test
	public void missingVariableRaisesException(){
		String name = "myvar";
		try{
			new Variable(name).evaluate(variable);
			fail("Missing variable value should raise an Exception");
		}catch(MissingValueException e){
			assertEquals("No value for ${"+name+"}", e.getMessage());
		}
	}
}
