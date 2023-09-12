package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import Model.user;

public class userDao {

	public static void insertData(user u) {
		try {
			Connection con = DBConnection.createConnection();
			String sql = "insert into register_user(name,contact,email,password)values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			pst.executeUpdate();
			System.out.println("inserted data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from register_user where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static user login(user u) {
		user u1 = null;
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from register_user where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
                    u1=new user();
                    u1.setName(rs.getString("name"));
                    u1.setContact(rs.getLong("contact"));
                    u1.setEmail(rs.getString("email"));
                    u1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}
	
	public static void update(user u) {
		try {
			Connection con=DBConnection.createConnection();
			String url="update register_user set name=?,email=?,contact=?,password=? where id=?";
			PreparedStatement pst=con.prepareStatement(url);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setLong(3, u.getContact());
			pst.setString(4, u.getPassword());
			pst.executeUpdate();
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	

}
