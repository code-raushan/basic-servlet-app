package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException{
		
//		int k =(int) req.getAttribute("k");
//		k = k * k;
		
		HttpSession session = req.getSession();
		int k = (int) session.getAttribute("k");
		k = k*k;
		
		Cookie[] cookies = req.getCookies();
		int x=0;
		for(Cookie c: cookies) {
			if(c.getName().equals("x")) {
				x = Integer.parseInt(c.getValue());
				x = x*x;
			}
		}
		
		PrintWriter out = res.getWriter();
		out.println("The squared result is "+k + " from the computation from session variable");
		out.println("The squared result is "+x + " from the computation from cookie variable");

		
	}

}
