package com.ceiba.demo.infrastructure.adapter.messagebroker.rabbitmq;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.MessageSender;
import com.ceiba.demo.infrastructure.adapter.messagebroker.rabbitmq.config.ApplicationConfigReader;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqMessage implements MessageSender {

	private final RabbitTemplate rabbitTemplate;
	private final ApplicationConfigReader applicationConfigReader;
	private String exchange;

	@Autowired
	public RabbitMqMessage(RabbitTemplate rabbitTemplate, ApplicationConfigReader applicationConfigReader) {
		this.rabbitTemplate = rabbitTemplate;
		this.applicationConfigReader = applicationConfigReader;
		this.exchange = this.applicationConfigReader.getAppExchange();
	}

	@Override
	public void sendMessageAdult(Person person) {
		
		String routingKey = this.applicationConfigReader.getApp2RoutingKey();
		this.rabbitTemplate.convertAndSend(exchange, routingKey, person);

	}

	@Override
	public void sendMessageYoung(Person person) {
		String routingKey = this.applicationConfigReader.getApp1RoutingKey();
		this.rabbitTemplate.convertAndSend(exchange, routingKey, person);
	}

}
