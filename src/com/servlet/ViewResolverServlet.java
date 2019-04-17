package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;


@WebServlet("/views/*")
public class ViewResolverServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = PREFIX + uri + SUFFIX;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}







