package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String os;
	
	private LinkedHashMap<String, String> countryoptions;
	
	public Student() {
		// TODO Auto-generated constructor stub
		countryoptions=new LinkedHashMap<>();
		countryoptions.put("BR", "Brazil");
		countryoptions.put("IN", "India");
		countryoptions.put("GR", "Germany");
		countryoptions.put("LA", "LosAngeles");

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryoptions() {
		return countryoptions;
	}

	public void setCountryoptions(LinkedHashMap<String, String> countryoptions) {
		this.countryoptions = countryoptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	
}
