package Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.userDao;
import model.user;

/**
 * Servlet implementation class userController
 */
@WebServlet("/userController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024* 512)

public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userController() {
        super();
    }
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	  String action=request.getParameter("action");
	  if(action.equalsIgnoreCase("Register")) {
		  user u=new user();
		  String savePath="C:\\Users\\User\\eclipse-workspace\\assign_04_10\\src\\main\\webapp\\images";
		  File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("pimage");
		 	String fileName = extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\User\\eclipse-workspace\\assign_04_10\\src\\main\\webapp\\images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	            }
	        u.setImage(fileName);
	        u.setFirst_name(request.getParameter("firstname"));
	        u.setLast_name(request.getParameter("lastname"));
	        u.setGender(request.getParameter("gender"));
	        u.setMobile(Long.parseLong(request.getParameter("mobile")));
	        u.setEmail(request.getParameter("email"));
	        u.setPassword(request.getParameter("password"));
	        userDao.insertUser(u);
	        System.out.println("done");
	  
	  }
			  
	
	
	
	}

}
