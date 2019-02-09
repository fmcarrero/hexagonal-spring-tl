package com.example.core.adapters;

import com.example.core.domain.Person;
import com.example.core.ports.ApplicationConfigReader;
import com.example.core.ports.MessageSender;
import com.example.core.ports.People;
import com.example.core.ports.PersonRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonAdapter implements People {

	private ApplicationConfigReader applicationConfig;
	private MessageSender messageSender;
	private PersonMaker personMaker;
	private PersonRepository personRepository;

	@Autowired
	public PersonAdapter(PersonRepository personRepository, PersonMaker personMaker, MessageSender messageSender,
			ApplicationConfigReader applicationConfig) {
		this.personRepository = personRepository;
		this.personMaker = personMaker;
		this.messageSender = messageSender;
		this.applicationConfig = applicationConfig;
	}

	@Override
	public List<Person> readPeople() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> readPerson(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person createPerson(Person person) {
		Person personFactory = this.personMaker.makeFactoryPerson(person);
		String exchange = this.applicationConfig.getApp1Exchange();
		String routingKey = personFactory.GetRoutingKey();
		this.messageSender.sendMessage(exchange, routingKey, personFactory);
		return person;
	}
}
