package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBApplication;
import com.model.Register;

/**
 * Servlet implementation class TransactionServlet
 */
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBApplication db=new DBApplication();
		String s1=request.getParameter("amount");
		int amnt=Integer.parseInt(s1);
		
		System.out.println(amnt);
		HttpSession session1 = request.getSession();
		int rn = (Integer)session1.getAttribute("val2");
		
		System.out.println("val2 t:"+rn);

		boolean flag=db.withdraw(amnt,rn);
		
		
		
		
		
		if(flag==true) {
			response.sendRedirect("Success.jsp");

		}
		else
		{
			response.sendRedirect("Login.jsp");

		
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub}
		doGet(request, response);

	}

}
