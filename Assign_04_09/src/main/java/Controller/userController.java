package Controller;

import java.io.IOException;

import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.userDao;
import Model.user;
import Service.mailService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Register")) {
			user u = new user();
			String email = request.getParameter("email");
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			userDao.insertData(u);
			mailService m = new mailService();
			Random r = new Random();
			int num = r.nextInt(9999);

			m.sendMail(email, num);
			request.setAttribute("otp", num);
			request.getRequestDispatcher("otpVerify.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("Verify")) {
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("msg", "Data incerted successfully");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Please Enter correct OTP..");
				request.getRequestDispatcher("otpVerify.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("login")) {
			String email = request.getParameter("email");
			boolean flag = userDao.checkEmail(email);
			if (flag == true) {
				user u = new user();
				u.setEmail(request.getParameter("email"));
				u.setPassword(request.getParameter("password"));
				user u1 = userDao.login(u);
				if (u1 == null) {
					request.setAttribute("msg2", "password is incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
			}
		} else if (action.equalsIgnoreCase("update")) {
           user u=new user();
            u.setName(request.getParameter("name"));
            u.setContact(Long.parseLong(request.getParameter("contact")));
            u.setEmail(request.getParameter("email"));
            u.setPassword(request.getParameter("password"));
            userDao.update(u);
            response.sendRedirect("home.jsp");
            
		}
	}

}
