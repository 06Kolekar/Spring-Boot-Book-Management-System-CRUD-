package com.jdbc.Books.controller;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.Books.entity.Entity;
import com.jdbc.Books.service.Services;

@RestController
public class Controller {

	
	private Services service=new Services();;
	
	@PostMapping("addBook")
	public Entity insertBook(@RequestBody Entity entity) {
		System.out.println(2);
		return service.insertBook(entity);	
	}
	
	@GetMapping("getBook")
	public ArrayList<Entity> getAllBook(){
		return service.getAllBook();
	}
	
	@PutMapping("updateBook")
	public void putBook(String name , String author , double price , int id) {
		service.putBook(name, author, price, id);
	}
	
	@DeleteMapping("deleteBook")
	public void deleteBook(int id) {
		service.deleteBook(id);
	}
	
	@GetMapping("fetchBook/{id}")
	public Entity fetachbookbyID(@PathVariable int id ) {
		return service.fetachbookbyID(id);
	}
	
	@PostMapping("addAllBooks")
	public ArrayList<Entity> addAllBooks(@RequestBody ArrayList<Entity> entity) {
		return service.addAllBooks(entity);
	}
}
