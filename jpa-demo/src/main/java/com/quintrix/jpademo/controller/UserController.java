package com.quintrix.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.quintrix.jpademo.model.User;
import com.quintrix.jpademo.service.Service;

@RestController
public class UserController {
	
	@Autowired
	Service service;
	@GetMapping("/main")
	public String helloWorld() {
		return "Welcome";
	}
	
	@GetMapping("/main/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		return service.getUser(id);
	}
	
	@GetMapping("/main/all")
	public ResponseEntity<List<User>> getAllUsers (){
		return service.getAllUsers();
	}
	
	@PostMapping("/main")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return service.createUser(user);
	}
	
	@PutMapping("/main/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user){
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("main/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id){
		return service.deleteUser(id);
	}
}
