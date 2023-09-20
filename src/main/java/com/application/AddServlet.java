package com.application;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	/**
	 * @throws ServletException 
	 * 
	 */

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
//		req.setAttribute("k", k);
		
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
		int x = k;
		
		Cookie cookie = new Cookie("x", x+"");
		res.addCookie(cookie);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("k", k);
		
		res.sendRedirect("square"); // redirecting to the square servlet
		
	}
	

}
