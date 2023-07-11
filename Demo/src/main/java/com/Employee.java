package com;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	private int userID;
	private String name;
	private String designation;
	
	@Id
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
