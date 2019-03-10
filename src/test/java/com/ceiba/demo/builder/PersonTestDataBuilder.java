package com.ceiba.demo.builder;

import com.ceiba.demo.domain.model.Person;

public class PersonTestDataBuilder {
    private static final long ID = 100;
    private static final String NAME = "peter";
    private static final String LASTNAME = "gonzalez";
    private static final int AGE= 50;


    private long id;
    private String name;
    private String lastName;
    private int age;


    public PersonTestDataBuilder() {
        this.id = ID;
        this.name = NAME;
        this.lastName = LASTNAME;
        this.age = AGE;
    }
    public PersonTestDataBuilder withId(long id) {
        this.id = id;
        return this;
    }
    public PersonTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public PersonTestDataBuilder withlastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public PersonTestDataBuilder withAge(int age) {
        this.age = age;
        return this;
    }
    public Person build() {
        Person person=  new Person( this.name, this.lastName, this.age);
        person.setId(id);
        return person;
    }
    
}
