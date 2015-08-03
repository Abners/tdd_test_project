package tdd_test_project;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015年7月29日下午5:11:53
 *
 * @version 1.0.0
 */
public class RegexLearningTest {
	@Test
	public void testHowGroupCountWorks(){
		String stack = "needles of needles nad";
		String regex = "(needle)";
		Matcher matcher = Pattern.compile(regex).matcher(stack);
		//matcher.groupCount()方法返回的是正则表达式本身包含的子表达式
		assertEquals(1,matcher.groupCount());
	}
	
	@Test
	public void testFindStartAndEnd(){
		String stack = "the needle shop sells needles";
		String regex = "(needle)";
		Matcher matcher = Pattern.compile(regex).matcher(stack);
		assertTrue(matcher.find());
		assertEquals("Wrong start index of 1st match",4, matcher.start());
		assertEquals("Wrong end index of 1st math, actual",10,matcher.end());
		
		assertTrue(matcher.find());
		assertEquals("Wrong start index of 1st match",22, matcher.start());
		assertEquals("Wrong end index of 1st math, actual",28,matcher.end());
		
		assertFalse("should not have any more matches",matcher.find());
	}
}
