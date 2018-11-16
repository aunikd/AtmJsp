package com.controller;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBApplication;
import com.model.Register;

/**
 * Servlet implementation class RegistrationServlet to obtain and store data into db/table
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

	Register r=new Register();
	r.setRno(Integer.parseInt(request.getParameter("rno")));
	r.setFname(request.getParameter("fname"));
	r.setPass(request.getParameter("pass"));
	r.setBal(Double.parseDouble(request.getParameter("bal")));
	r.setPass(request.getParameter("acctype"));

	
	DBApplication db=new DBApplication();
	List<Register> lst=new LinkedList<Register>();
	lst.add(r);
	int i=db.saveData(lst);
	System.out.println("test2 iw value"+i);
	if(i>0)
	{
		response.sendRedirect("Login.jsp");
	}
	System.out.println("test4");
	
	
	
	
	
	
		
		
		
	}
}
