package com.ceiba.demo.infrastructure.adapter.messagebroker.rabbitmq;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageListener {

	private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

	private PersonRepository personRepository;

	@Autowired
	public MessageListener(final PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	/**
	 * Message listener for app1
	 * 
	 * @param person a user defined object used for deserialization of message
	 */
	@RabbitListener(queues = "${app1.queue.name}")
	public void receiveMessageForApp1(final Person person) {
		log.info("Received message: {} from app1 queue.", person);
		this.savePerson(person);
		log.info("<< Exiting receiveMessageForApp1() after API call.");
	}

	/**
	 * Message listener for app2
	 * @param person a user defined object used for deserialization of message
	 */

	@RabbitListener(queues = "${app2.queue.name}")
	public void receiveMessageForApp2(final Person person) {
		log.info("Received message: {} from app2 queue.", person);
		this.savePerson(person);
		log.info("<< Exiting receiveMessageForApp1() after API call.");
	}

	private Person savePerson(Person person) {
		return this.personRepository.save(person);
	}

}
