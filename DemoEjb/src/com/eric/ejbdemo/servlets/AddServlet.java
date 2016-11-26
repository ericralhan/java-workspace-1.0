package com.eric.ejbdemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eric.ejbdemo.beans.AddEjb;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Servlet to add two numbers", urlPatterns = { "/AddServlet" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AddEjb obj;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));

		obj.setI(i);
		obj.setJ(j);

		obj.add();
		int k = obj.getK();

		out.println("Addition is : " + k);

	}

}
