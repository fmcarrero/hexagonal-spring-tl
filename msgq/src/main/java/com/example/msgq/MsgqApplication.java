package com.example.msgq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.example.msgq.config.ApplicationConfigReaderImpl;

@EnableRabbit
public class MsgqApplication extends SpringBootServletInitializer implements RabbitListenerConfigurer {

	@Autowired
	private ApplicationConfigReaderImpl applicationConfig;
	
	public ApplicationConfigReaderImpl getApplicationConfig() {
		return applicationConfig;
	}
	
	public void setApplicationConfig(ApplicationConfigReaderImpl applicationConfig) {
		this.applicationConfig = applicationConfig;
	}	
	
	/* This bean is to read the properties file configs */	
	@Bean
	public ApplicationConfigReaderImpl applicationConfig() {
		return new ApplicationConfigReaderImpl();
	}
	
	/* Creating a bean for the Message queue Exchange */
	@Bean
	public TopicExchange getApp1Exchange() {
		return new TopicExchange(getApplicationConfig().getApp1Exchange());
	}

	/* Creating a bean for the Message queue */
	@Bean
	public Queue getApp1Queue() {
		return new Queue(getApplicationConfig().getApp1Queue());
	}

	/* Creating a bean for the Message queue */
	@Bean
	public Queue getApp2Queue() {
		return new Queue(getApplicationConfig().getApp2Queue());
	}
	
	
	/* Binding between Exchange and Queue using routing key */
	@Bean
	public Binding declareBindingApp1(TopicExchange getApp1Exchange, Queue getApp1Queue) {
		return BindingBuilder.bind(getApp1Queue).to(getApp1Exchange).with(getApplicationConfig().getApp1RoutingKey());
	}
	/* Binding between Exchange and Queue using routing key */
	@Bean
	public Binding declareBindingApp2(TopicExchange getApp1Exchange, Queue getApp2Queue) {
		return BindingBuilder.bind(getApp2Queue).to(getApp1Exchange).with(getApplicationConfig().getApp2RoutingKey());
	}
	



	/* Bean for rabbitTemplate */
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	
	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
	
	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}
	@Override
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}
	
	
	
}
