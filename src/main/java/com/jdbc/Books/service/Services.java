package com.jdbc.Books.service;


import java.util.ArrayList;

import com.jdbc.Books.dao.DAO;
import com.jdbc.Books.entity.Entity;


public class Services {

	
	private DAO dao=new DAO();;

	public Entity insertBook(Entity entity) {
		System.out.println(1);
		return dao.insertBook(entity);
	}
	
	public ArrayList<Entity> getAllBook(){
		return dao.getAllBook();
	}
	
	public void putBook(String name , String author , double price , int id) {
		dao.putBook(name, author, price, id);
	}
	
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}
	
	public Entity fetachbookbyID(int id ) {
		return dao.fetachbookbyID(id);
	}
	
	public ArrayList<Entity> addAllBooks(ArrayList<Entity> entity) {
		return dao.addAllBooks(entity);
	}
}
