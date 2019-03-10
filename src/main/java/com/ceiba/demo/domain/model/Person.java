package com.ceiba.demo.domain.model;

import java.io.Serializable;

import com.ceiba.demo.domain.model.validation.ValidationPerson;

public class Person implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int AGE_ADULT = 18;

	private long id;
	private String name;
	private String lastName;
	private int age;

	public Person() {}
	
	public Person(String name, String lastName, int age) {

		ValidationPerson.validateNotNull(name, "El campo nombre deberia tener un valor valido");
		ValidationPerson.validateNotNull(lastName, "El campo apellido deberia tener un valor valido");
		ValidationPerson.validateAge(age, "El campo deberia ser mayo a 0");
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}

	public boolean isAdult() {
		if (this.age > this.AGE_ADULT) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
	

}
