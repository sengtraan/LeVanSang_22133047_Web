package web1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/trangchu"})
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -883555915311596535L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
//		String ten = req.getParameter("ten");
//		String holot = req.getParameter("holot");
		
		PrintWriter printW = resp.getWriter();
		
		printW.println("<h1>HelloWorld</h1>");
			
//		printW.println(holot + " " + ten);
//		printW.close();

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html");
		
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		
		PrintWriter printW = resp.getWriter();
		
		printW.println("<h1>HelloWorld</h1>");
			
//		printW.println(holot + " " + ten);
//		printW.close();
	}
	
}
