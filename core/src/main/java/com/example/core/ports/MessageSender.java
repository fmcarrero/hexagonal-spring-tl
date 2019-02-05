package com.example.core.ports;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface MessageSender {
	void sendMessage(RabbitTemplate rabbitTemplate, String exchange, String routingKey, Object data);
}
