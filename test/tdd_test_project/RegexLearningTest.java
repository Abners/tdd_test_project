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
		assertEquals(2,matcher.groupCount());
	}
}
