package com.example.data.builder;

import com.example.jpa.entities.JpaPerson;

public class JpaPersonTestDataBuilder {

	private static final long ID = 100;
	private static final String NAME = "peter";
	private static final String LASTNAME = "gonzalez";
	private static final int AGE = 50;

	private long id;
	private String name;
	private String lastName;
	private int age;

	public JpaPersonTestDataBuilder() {
		this.id = ID;
		this.name = NAME;
		this.lastName = LASTNAME;
		this.age = AGE;
	}
	public JpaPersonTestDataBuilder withId(long id) {
		this.id = id;
		return this;
	}
	public JpaPersonTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public JpaPersonTestDataBuilder withlastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public JpaPersonTestDataBuilder withAge(int age) {
		this.age = age;
		return this;
	}

	public JpaPerson build() {
		JpaPerson jpaPerson = new JpaPerson();
		jpaPerson.setAge(this.age);
		jpaPerson.setId(this.id);
		jpaPerson.setName(this.name);
		jpaPerson.setLastName(this.lastName);
		return jpaPerson;
	}
}
