package com.example.msgq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.core.ports.MessageSender;
import com.example.core.ports.RabbitTemplateCustom;


@Component
public class MessageSenderImpl implements  MessageSender{
	
	private final RabbitTemplateCustom rabbitTemplate;
	
	@Autowired
	public MessageSenderImpl (RabbitTemplateCustom rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	private static final Logger log = LoggerFactory.getLogger(MessageSenderImpl.class);
	
	/**
	 * 
	 * @param rabbitTemplate
	 * @param exchange
	 * @param routingKey
	 * @param data
	 */
	public void sendMessage( String exchange, String routingKey, Object data) {
		log.info("Sending message to the queue using routingKey {}. Message= {}", routingKey, data);
		this.rabbitTemplate.getRabbitTemplate().convertAndSend(exchange, routingKey, data);
		log.info("The message has been sent to the queue.");
	}	

}
