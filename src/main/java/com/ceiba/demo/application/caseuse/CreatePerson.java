package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;

public class CreatePerson {


	private MessageSender rabbitMqMessage;

	@Autowired
	public CreatePerson(MessageSender messageSender){
		this.rabbitMqMessage = messageSender;
	}

	public Person create(Person person){
		this.rabbitMqMessage.sendMessage(person);
		return person;
	}

}
