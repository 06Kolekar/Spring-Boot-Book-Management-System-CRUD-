package com.jdbc.Books.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.Books.entity.User;
import com.jdbc.Books.service.UserService;

@RestController
public class UserController {

	private UserService userService = new UserService();
	
	@GetMapping("addUser")
	public void addUser(@RequestParam String name , @RequestParam String  username , @RequestParam String password) {
		userService.addUser(name, username, password);
	}
	
	@GetMapping("showUser")
	public ArrayList<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("Login")
	public boolean checkUser(@RequestParam String username ,@RequestParam String password) {
		return userService.chaekUser(username, password);
	}
}
