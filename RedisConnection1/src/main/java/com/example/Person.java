package com.example;

import java.io.Serializable;

/*
https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:support:cache-abstraction
*/

public class Person implements Serializable {
	
	private static final long serialVersionUID = -8243145429438016231L;
	
	public enum Gender{Male,Female};
	
	private String firstname;
	private String lastname;
	private String company;
	private Gender gender;
	private int    age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        return result;
		
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person)obj;
		if (age != other.age)
			return false;
		
		if (gender == null && other.gender != null)
			return false;
		
		if (!gender.equals(other.gender))
			return false;
		
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
				return false;
		
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		}
		else if (!firstname.equals(other.firstname))
				return false;
			
		return true;
	}
	
	public String toString() {
		return "Person [id=" + id + ", name=" + firstname + " " + lastname + ", gender=" + gender + ", age=" + age + "]";
		
	}
}
