package com.quintrix.jpademo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.quintrix.jpademo.model.User;
import com.quintrix.jpademo.repo.RepoInterface;

@Component
public class Service implements ServiceInterface{
	
	@Autowired
	RepoInterface repo;

	@Override
	public ResponseEntity<User> getUser(int id) {
		Optional<User> userData = repo.findById(id);
		if(userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<List<User>> getAllUsers(){
		try {
			List<User> users = new ArrayList<User>();
			repo.findAll().forEach(x -> {users.add(x);});
			if(users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<User> createUser(User user) {
		try {
			User newUser = repo.save(new User(user.getId(), user.getFirstName(), user.getLastName()));
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<User> updateUser(int id, User user) {
		Optional<User> userData = repo.findById(id);
		if(userData.isPresent()) {
			User newUser = userData.get();
			newUser.setId(user.getId());
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			return new ResponseEntity<>(repo.save(newUser), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteUser(int id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
