package com.example.core.adapters;

import com.example.core.domain.Person;
import com.example.core.domain.Young;
import com.example.core.ports.ApplicationConfigReader;
import com.example.core.ports.MessageSender;
import com.example.core.ports.People;
import com.example.core.ports.PersonRepository;
import com.example.core.ports.RabbitTemplateCustom;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

public class PersonAdapter implements People {

	private final RabbitTemplateCustom rabbitTemplate;
	private ApplicationConfigReader applicationConfig;
	private MessageSender messageSender;

    private PersonRepository personRepository;
    
    public ApplicationConfigReader getApplicationConfig() {
		return applicationConfig;
	}   


	@Autowired
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	

	@Autowired
	public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
		this.applicationConfig = applicationConfig;
	}
	@Autowired
    public PersonAdapter(PersonRepository peopleRepository,final RabbitTemplateCustom rabbitTemplate) {
        this.personRepository = peopleRepository;
        this.rabbitTemplate = rabbitTemplate;
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
    	Person young = (Young) person;    	
    	String exchange = young.GetNameExchange();
		String routingKey = getApplicationConfig().getApp1RoutingKey();
    	messageSender.sendMessage(rabbitTemplate.getRabbitTemplate(), exchange, routingKey, person);		
        return person;
    }
}
