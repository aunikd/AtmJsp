package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
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

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//TAKING AMOUNT VALUE
		

		
		System.out.println("dsplayserv1");
		DBApplication db=new DBApplication();
		List<Register> lst=db.getAllData();
		System.out.println("dsplayserv2");
		
		//passing value from servlet
		String chk1 = (String)(request.getAttribute("val1"));
		int chk=Integer.parseInt(chk1);
		//int chk=Integer.parseInt(rn);
		
		PrintWriter pw = null;
		
		for(Register r:lst)
		{
			if(chk==r.getRno()){
				//SENDING VALUE TO USERPAGE JSP
				try {
					request.setAttribute("myname",r.getFname());			
					request.getRequestDispatcher("UserPage.jsp");
					
					
					String myno= Integer.toString(r.getRno());
					request.setAttribute("myno",myno);			
					request.getRequestDispatcher("UserPage.jsp");
					
					
					String mybal=Double.toString(r.getBal());
					request.setAttribute("mybal",mybal);			
					request.getRequestDispatcher("UserPage.jsp").forward(request, response);
					
					System.out.println("val2:"+chk);
					HttpSession session1=request.getSession(true);
					session1.setAttribute("val2",r.getRno());
					
					response.sendRedirect("TransactionServlet");

					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				//CONSOLE PRINT
				//pw.print("<tr><td>"+r.getFname()+"</td><td>"+r.getRno()+"</td><tr>"+r.getBal()+"</td><tr>");
				
				
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
