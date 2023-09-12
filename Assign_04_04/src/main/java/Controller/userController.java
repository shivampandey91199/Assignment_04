package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.userModel;

/**
 * Servlet implementation class userController
 */
@WebServlet("/userController")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
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
			userModel u=new userModel();
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setContact(Long.parseLong(request.getParameter("mobile")));
			u.setGender(request.getParameter("gender"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			request.setAttribute("data", u);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	
	
	
	}

}
