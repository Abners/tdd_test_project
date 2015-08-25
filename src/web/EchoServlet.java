package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 * @author baoxing.peng
 *
 * @since 2015年8月25日上午8:49:45
 *
 * @version 1.0.0
 */
public class EchoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Content-Type", "text/plain");
		PrintWriter writer = response.getWriter();
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String parameter = String.valueOf(e.nextElement());
			String[] values = request.getParameterValues(parameter);
			for(int i=0;i<values.length;i++){
				writer.write(parameter+"="+values[i]);
				writer.write("\n");
			}
		}
		writer.close();
	}
}
