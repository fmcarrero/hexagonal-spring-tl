package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.application.command.PersonCommand;
import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.MessageSender;
import org.springframework.stereotype.Service;

@Service
public class CreatePerson {

	private MessageSender rabbitMqMessage;

	
	public CreatePerson(MessageSender messageSender) {
		this.rabbitMqMessage = messageSender;
	}

	public Person create(PersonCommand personCommand) {
		Person person = new Person(personCommand.getName(), personCommand.getLastName(), personCommand.getAge());
		if (person.isAdult()) {
			this.rabbitMqMessage.sendMessageAdult(person);
		} else {
			this.rabbitMqMessage.sendMessageYoung(person);
		}

		return person;
	}

}
