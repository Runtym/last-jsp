package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.Common;

@WebServlet(urlPatterns = {"/addr/*"})
public class AddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String cmd = Common.getCmd(request);
		String url = "/views/addr/" + cmd;
		if("list".equals(cmd)) {
			request.setAttribute("list", "난 리스트지~~");
		}else if("one".equals(cmd)) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
