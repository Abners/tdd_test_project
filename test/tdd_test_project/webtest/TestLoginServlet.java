package tdd_test_project.webtest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import web.LoginServlet;

public class TestLoginServlet {
	@Test
	public void wrongPasswordShouldRedirectToErrorPage() throws ServletException, IOException{
		HttpServlet servlet = new LoginServlet();
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/login");
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("j_username", "nosuchuser");
		request.addParameter("j_password", "wrongpassword");
		servlet.service(request, response);
		
		assertEquals("/invalidLogin",response.getRedirectedUrl());
		
	}
	
	@Test
	public void validLoginForwardsToFrontPageAndStoreUserName()throws Exception{
		HttpServlet servlet = new LoginServlet();
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/login");
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("j_username", "validuser");
		request.addParameter("j_password", "correctpassword");
		servlet.service(request, response);
		assertEquals("/frontpage", response.getRedirectedUrl());
		assertEquals("validuser", request.getSession().getAttribute("username"));
	}
}
