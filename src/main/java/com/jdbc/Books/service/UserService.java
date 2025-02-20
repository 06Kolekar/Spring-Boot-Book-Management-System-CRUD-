package com.jdbc.Books.service;

import java.util.ArrayList;

import com.jdbc.Books.dao.UserDAO;
import com.jdbc.Books.entity.User;

public class UserService {

	private UserDAO userDao = new UserDAO();
	
	public void addUser(String name , String username , String password) {
		userDao.addUser(name, username, password);
	}
	
	public ArrayList<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	public Boolean chaekUser(String username , String password) {
		boolean b = UserDAO.checkUser(username, password);
		if(b) {
			System.out.println("Login successfull!");
		}
		else {
			System.out.println("Invalid Username or password!");
		}
		
		return b;
	}
}
