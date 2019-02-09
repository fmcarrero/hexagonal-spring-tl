package com.example.data.builder;

import com.example.core.domain.Adult;
import com.example.core.domain.Person;

public class AdultTestDataBuilder {
	
	private static final long ID = 100;
	private static final String NAME = "peter";
	private static final String LASTNAME = "gonzalez";
    private static final int AGE= 50;


	private long id;
	private String name;
	private String lastName;
	private int age;
	

	public AdultTestDataBuilder() {
		this.id = ID;
		this.name = NAME;
		this.lastName = LASTNAME;
		this.age = AGE;
	}
	public AdultTestDataBuilder withId(long id) {
		this.id = id;
		return this;
	}
	public AdultTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public AdultTestDataBuilder withlastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public AdultTestDataBuilder withAge(int age) {
		this.age = age;
		return this;
	}
	public Person build() {
		return  new Adult(this.id, this.name, this.lastName, this.age);			
	}

}
