package com.example;

public class User {
    private String firstName;
	private String lastName;
 
	
	   @Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + "]";
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public User(String firstName, String lastName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public User() {
	}
	
	
}
