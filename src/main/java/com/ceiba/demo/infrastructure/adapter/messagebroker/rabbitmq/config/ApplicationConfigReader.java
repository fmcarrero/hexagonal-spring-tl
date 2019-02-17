package com.ceiba.demo.infrastructure.adapter.messagebroker.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigReader {
	
	@Value("${app1.exchange.name}")
	private String app1Exchange;
	
	@Value("${app1.queue.name}")
	private String app1Queue;
	
	@Value("${app1.routing.key}")
	private String app1RoutingKey;

	
	@Value("${app2.queue.name}")
	private String app2Queue;
	
	@Value("${app2.routing.key}")
	private String app2RoutingKey;
	
	@Value("${age}")
	private int age;

	public String getAppExchange() {
		return app1Exchange;
	}

	public String getApp1Queue() {
		return app1Queue;
	}	

	public String getApp1RoutingKey() {
		return app1RoutingKey;
	}

	public String getApp2Queue() {
		return app2Queue;
	}

	public String getApp2RoutingKey() {
		return app2RoutingKey;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
		
	}
	
}
