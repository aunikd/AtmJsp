package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBApplication;
import com.model.Register;

/**
 * Servlet implementation class ForgotServlet for retrieve password based on unique rno
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String s1=request.getParameter("rno");
		int rno=Integer.parseInt(s1);
		
		DBApplication db=new DBApplication();
		List<Register> lst=db.getAllData();
		
		
		for(Register r:lst)
		{
			if(rno==r.getRno()){
				//SENDING VALUE TO FORGOT JSP
				request.setAttribute("mypass",r.getPass());			
				request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
		
			}
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
