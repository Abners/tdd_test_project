package tdd_test_project.webtest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import web.EchoServlet;

public class TestEchoServlet {
	@Test
	public void testEchoingParametersWithMultipleValues() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("param1", "param1value1");
		request.addParameter("param2", "param2value2");
		request.addParameter("param3", "param3value3");
		request.addParameter("param4", "param4value4");
		
		new EchoServlet().doGet(request, response);
		String[] lines = response.getContentAsString().split("\n");
		assertEquals("Except as many lines as we have parameter values",4,lines.length);
		assertEquals("param1=param1value1",lines[0]);
		assertEquals("param2=param2value2",lines[1]);
		assertEquals("param3=param3value3",lines[2]);
		assertEquals("param4=param4value4",lines[3]);
	}
}
