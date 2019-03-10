package com.ceiba.demo.builder;

import com.ceiba.demo.application.command.PersonCommand;


public class PersonCommandTestDataBuilder {
    
	
    private static final String NAME = "peter";
    private static final String LASTNAME = "gonzalez";
    private static final int AGE= 50;

    
    private String name;
    private String lastName;
    private int age;


    public PersonCommandTestDataBuilder() {
    
        this.name = NAME;
        this.lastName = LASTNAME;
        this.age = AGE;
    }
    
    public PersonCommandTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public PersonCommandTestDataBuilder withlastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public PersonCommandTestDataBuilder withAge(int age) {
        this.age = age;
        return this;
    }
    public PersonCommand build() {
    	PersonCommand personCommand = new PersonCommand();
    	personCommand.setAge(this.age);
    	personCommand.setLastName(this.lastName);
    	personCommand.setName(this.name);
    	return personCommand;
    	
    }
    
}
