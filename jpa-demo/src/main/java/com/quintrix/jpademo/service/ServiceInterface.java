package com.quintrix.jpademo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quintrix.jpademo.model.User;

public interface ServiceInterface {
	
	ResponseEntity<User> getUser(int id);
	
	ResponseEntity<List<User>> getAllUsers();
	
	ResponseEntity<User> createUser(User user);
	
	ResponseEntity<User> updateUser(int id, User user);
	
	ResponseEntity<HttpStatus> deleteUser(int id);
	
}
