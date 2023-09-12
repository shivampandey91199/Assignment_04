package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.studentDao;
import Model.student;
@WebServlet("/studentController")
public class studentController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   
		  String action=request.getParameter("action");
		  if(action.equalsIgnoreCase("Register")) {
			  student s=new student();
			  s.setFname(request.getParameter("fname"));
			  s.setLname(request.getParameter("lname"));
			  s.setContact(Long.parseLong(request.getParameter("contact")));
			  s.setGender(request.getParameter("gender"));
			  s.setEmail(request.getParameter("email"));
			  s.setPassword(request.getParameter("password"));
			  studentDao.insertStudent(s);
			  request.setAttribute("msg","Data inserted successfully");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
			 }else if(action.equalsIgnoreCase("login")) {
				 String email=request.getParameter("email");
				 String password=request.getParameter("password");
				 student s=new student();
				 s.setEmail(email);
				 s.setPassword(password);
				 student ss=studentDao.login(email, password);
		         request.setAttribute("data",ss);
		         request.getRequestDispatcher("home.jsp").forward(request, response);
			 }else if(action.equalsIgnoreCase("update")) {
				  int id=Integer.parseInt(request.getParameter("id"));
				  System.out.println(id);
				  student s=new student();
				  s.setFname(request.getParameter("fname"));
				  s.setLname(request.getParameter("lname"));
				  s.setContact(Long.parseLong(request.getParameter("contact")));
				  s.setEmail(request.getParameter("email"));
				  studentDao.updateStudent(s);
				  response.sendRedirect("home.jsp");
			 }
	
	
	}

}
