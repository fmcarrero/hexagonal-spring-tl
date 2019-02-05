package com.example.msgq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.core.ports.RabbitTemplateCustom;



@Configuration
public class RabbitTemplateImpl implements RabbitTemplateCustom {

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public RabbitTemplateImpl(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public RabbitTemplate getRabbitTemplate() {	
		return rabbitTemplate;
	}

}
