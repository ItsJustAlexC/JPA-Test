package com.quintrix.jpademo.model;

import javax.persistence.*;


@Entity
@Table(name = "entity")
public class User {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public User() {}

	public User(int id, String firstName, String lastName) {
	    this.id = id;
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }

	public int getId() {
	    return id;
	    }

	public void setId(int newId) {
	    this.id = newId;
	    }

	public String getFirstName() {
	    return firstName;
	    }

	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	    }

	public String getLastName() {
	    return lastName;
	    }

	public void setLastName(String lastName) {
	    this.lastName = lastName;
	    }
}