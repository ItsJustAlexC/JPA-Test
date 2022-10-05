package com.quintrix.jpademo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintrix.jpademo.model.User;

public interface RepoInterface extends JpaRepository<User, Integer>{
	
}
