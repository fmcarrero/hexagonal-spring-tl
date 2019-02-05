package com.example.core.ports;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface RabbitTemplateCustom {
	
	RabbitTemplate getRabbitTemplate();
}
