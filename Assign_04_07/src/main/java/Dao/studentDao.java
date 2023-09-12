package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connection.DBConnection;
import Model.student;

public class studentDao {
	

	public static void insertStudent(student s) {
		try {
			 Connection con=DBConnection.createConnection();
			 String sql="insert into student(fname,lname,contact,gender,email,password)values(?,?,?,?,?,?)";
			 PreparedStatement pst=con.prepareStatement(sql);
			 pst.setString(1, s.getFname());
			 pst.setString(2, s.getLname());
			 pst.setLong(3, s.getContact());
			 pst.setString(4,s.getGender());
			 pst.setString(5, s.getEmail());
			 pst.setString(6, s.getPassword());
			 pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public static student login(String email , String password) {
		student s=null;
		 try {
			 Connection con=DBConnection.createConnection();
			 String sql="select * from student where email=? nad password=?";
			 PreparedStatement pst=con.prepareStatement(sql);
			 pst.setString(1, email);
			 pst.setString(2, password);
			 ResultSet rs=pst.executeQuery();
             if(rs.next()) {
            	 s=new student();
            	 s.setFname(rs.getString("fname"));
                 s.setLname(rs.getString("lname"));
                 s.setContact(rs.getLong("contact"));
                 s.setGender(rs.getString("gender"));
                 s.setEmail(rs.getString("email"));
                 s.setPassword(rs.getString("password"));
                 }
 			   	} catch (Exception e) {
            	    e.printStackTrace();
		   }
		return s;
	}
	
	public static void updateStudent(student s) {
			try {
		         Connection con=DBConnection.createConnection();
		         String sql="update student set fname=?,lname=?,contact=?,gender=?,email=? where id=?";
		         PreparedStatement pst=con.prepareStatement(sql);
		         pst.setString(1, s.getFname());
		         pst.setString(2, s.getLname());
		         pst.setLong(3, s.getContact());
		         pst.setString(4, s.getGender());
		         pst.setString(5, s.getEmail());
		         pst.setInt(6, s.getId());
		         pst.executeUpdate();
		         System.out.println("updated...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
