package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* add annotation - 2nd method */
// @Component
// @Qualifier("manager")

/* add below - method 3 */
@Component
public class Manager implements Person {
	
	private String gender;
	private String info;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	
	@Override
	public String processInfo() {
		String info = "manager";
		return info;
	}
	
	@Override
	public String processGender() {
		String gender = "male";
		return gender;
	}
}
