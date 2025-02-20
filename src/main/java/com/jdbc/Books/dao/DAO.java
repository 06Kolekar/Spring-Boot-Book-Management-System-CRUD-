package com.jdbc.Books.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.Books.entity.Entity;


public class DAO {

	private static final String url = "jdbc:mysql://localhost:3306/book";
	private static final String user_name = "root";
	private static final String password = "";
	
	private static Connection con;
	private PreparedStatement pt;
	
	protected static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url,user_name,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			//throw new RuntimeException("Connection Fail!",e);
			e.printStackTrace();
		}
		return con;
	}
	
	public Entity insertBook(Entity entity) {
		String st = "insert into book1 (id,name,author,price) values(?,?,?,?);";
		Connection con = getConnection();
		
		try {
			pt = con.prepareStatement(st);
			pt.setInt(1, entity.getId());
			pt.setString(2, entity.getName());
			pt.setString(3, entity.getAuthor());
			pt.setDouble(4, entity.getPrice());
			System.out.println(entity.getId()+" "+entity.getName()+ " "+ entity.getAuthor()+" "+entity.getPrice());
			pt.executeUpdate();
			System.out.println("Data Enter Successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not done!");
		}
		return entity;
		
	}
	
	public ArrayList<Entity> getAllBook(){
		String st = "SELECT * FROM book1 ;";
		
		ArrayList<Entity> alentity = new ArrayList<Entity>();
		Connection con = getConnection();
		try {
			pt = con .prepareStatement(st);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String author = rs.getString(3);
				double price = rs.getDouble(4);
				alentity.add(new Entity(id ,name, author, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alentity;
	}
	
	public void putBook(String name , String author , double price , int id) {
		String st = "update book1 set name=? , author = ? , price =? where id =? ;";
		
		Connection con = getConnection();
		try {
			pt = con.prepareStatement(st);
			pt.setString(1, name);
			pt.setString(2, author);
			pt.setDouble(3, price);
			pt.setInt(4, id);
			pt.executeUpdate();
			System.out.println("Update successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int id) {
		String st = "delete from book1 where id =? ;";
		
		Connection con = getConnection();
		try {
			pt=con.prepareStatement(st);
			pt.setInt(1, id);
			pt.executeUpdate();
			System.out.println("Deletions Done!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Entity fetachbookbyID( int id ){
		String st = "select * from book1 where id =?";
		
		Connection con = getConnection();
		
		Entity entity = null;
		
		try {
			pt = con.prepareStatement(st);
			pt.setInt(1, id);
			ResultSet rs  = pt.executeQuery();
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				return entity = new Entity(id1, name, author, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
		
	}
	
	public ArrayList<Entity> addAllBooks(ArrayList<Entity> alentity ){
		
		String st = "insert into book1 (id,name,author,price) values(?,?,?,?);";
		
		Connection con = getConnection();
		
		for (Entity entity : alentity) {
			try {
				pt = con.prepareStatement(st);
				pt.setInt(1, entity.getId());
				pt.setString(2, entity.getName());
				pt.setString(3, entity.getAuthor());
				pt.setDouble(4, entity.getPrice());
				pt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return alentity;
		
	}
}
