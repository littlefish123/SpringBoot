package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* add below annotation when using 2nd method*/
// @Component
// @Qualifier("student")

/* add below - 3rd method */
@Component
public class Student implements Person {

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
			String info = "student";
			return info;
		}
		
		@Override
		public String processGender() {
			String gender = "female";
			return gender;
		}
	

}
