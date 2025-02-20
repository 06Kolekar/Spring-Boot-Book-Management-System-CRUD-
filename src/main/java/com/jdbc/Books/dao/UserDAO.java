package com.jdbc.Books.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.Books.entity.User;

public class UserDAO {

	private static Connection con;
	private PreparedStatement pt ;
	private DAO dao = new DAO();
	
	public User addUser(String name , String username , String password) {
		
		User user = new User();
		
		String st = " insert into userbook (name,username,password) values(?,?,?);";
		
		String stc = "Select * from  userbook where username = ? ;";
		con = DAO.getConnection();
		
		try {
			pt = con.prepareStatement(stc);
			pt.setString(1, username);
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				System.out.println("Already User Name Exists");
				System.out.println("Please use unique username or email");
			}else {
				pt = con.prepareStatement(st);
				pt.setString(1, name);
				pt.setString(2, username);
				pt.setString(3, password);
				pt.executeUpdate();

				System.out.println("User Add Successfully!");
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public ArrayList<User> getAllUser(){
		
		String st ="select * from userbook;";
		
		ArrayList<User> aluser = new ArrayList<User>();
		con = DAO.getConnection();
		
		try {
			pt = con.prepareStatement(st);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String user = rs.getString("username");
				String username = user.replaceAll(user, "*******");
				String pass = rs.getString("password");
				String password = pass.replaceAll(pass, "*******");
				aluser.add(new User(id, name, username, password));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aluser;
	}
	
	public static boolean checkUser(String username , String password) {
		String st = " select * from userbook where username = ? and password =?;";
		
		con = DAO.getConnection();
		
		PreparedStatement pts;
		
		try {
			
			pts = con.prepareStatement(st);
			pts.setString(1, username);
			pts.setString(2, password);
			
		
			try {
				ResultSet rs = pts.executeQuery();
				if (rs.next()) {
					return true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
