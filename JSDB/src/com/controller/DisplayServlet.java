package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBApplication;
import com.model.Register;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public DisplayServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBApplication db = new DBApplication();
		List<Register> lst = db.getAllData();
		request.setAttribute("display", lst);
		RequestDispatcher  rd = request.getRequestDispatcher("DisplayAll.jsp");
		rd.forward(request, response);	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
