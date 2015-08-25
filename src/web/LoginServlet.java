package web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.sendRedirect("/invalidLogin");
	}
}
