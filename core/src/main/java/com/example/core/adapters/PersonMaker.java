package com.example.core.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.core.domain.Adult;
import com.example.core.domain.Person;
import com.example.core.domain.Young;
import com.example.core.ports.ApplicationConfigReader;

@Component
public class PersonMaker {

	

	private ApplicationConfigReader applicationConfig;

	@Autowired
	public PersonMaker(ApplicationConfigReader applicationConfig) {
		this.applicationConfig = applicationConfig;
	}

	public Person makeFactoryPerson(Person person) {
		if (person.getAge() < this.applicationConfig.getAge()) {
			Young young = new Young(person.getId(), person.getName(), person.getLastName(), person.getAge());
			young.setAppRoutingKey(this.applicationConfig.getApp1RoutingKey());
			return young;
		}
		Adult adult = new Adult(person.getId(), person.getName(), person.getLastName(), person.getAge());
		adult.setAppRoutingKey(this.applicationConfig.getApp2RoutingKey() );
		return adult;
	}
}
