package com.example.core.domain;

import java.io.Serializable;

import com.example.core.exception.PersonNotFoundExchange;

public class Person  implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(Long id, String name, String lastName,int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age =  age;
    }
    
    @Override
	public String toString() {
		return "person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age  + "]";
	}
    public String GetNameExchange() {
    	throw new PersonNotFoundExchange();
    };
    
}
