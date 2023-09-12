

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ABCServlet
 */
@WebServlet("/ABCServlet")
public class ABCServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	
			ServletContext context = getServletContext();
			ServletConfig config = getServletConfig();
			System.out.println("ConfigObject"+config);
			System.out.println("ContextObject"+ context);
			
			String email = config.getInitParameter("email"); 
			
			resp.getWriter().write("ABC servlet " + context.getInitParameter("shop") );
			
			resp.getWriter().write("ABC servlet Init Param " + email );

		
		
		}

	

}
