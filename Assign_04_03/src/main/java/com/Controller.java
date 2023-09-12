package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		 String action=request.getParameter("action");
		 if(action.equalsIgnoreCase("register")) {
			 String fname=request.getParameter("fname");
			 String lname=request.getParameter("lname");
			 long mobile=Long.parseLong(request.getParameter("mobile"));
			 String gender=request.getParameter("gender");
			 String email=request.getParameter("email");
			 String password=request.getParameter("password");
			 
			 System.out.println("First name = "+fname);
			 System.out.println("last name  = "+lname);
			 System.out.println("Mobile     = "+mobile);
			 System.out.println("Gender     = "+gender);
			 System.out.println("Email      = "+email);
			 System.out.println("password   = "+password);
			 
			 
			 
			 
			 
		 }
	
	
	}

}
