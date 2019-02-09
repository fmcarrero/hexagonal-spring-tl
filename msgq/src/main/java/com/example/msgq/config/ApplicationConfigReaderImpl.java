package com.example.msgq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.example.core.ports.ApplicationConfigReader;

@Configuration
public class ApplicationConfigReaderImpl implements ApplicationConfigReader {
	
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

	public String getApp1Exchange() {
		return app1Exchange;
	}

	public void setApp1Exchange(String app1Exchange) {
		this.app1Exchange = app1Exchange;
	}

	public String getApp1Queue() {
		return app1Queue;
	}

	public void setApp1Queue(String app1Queue) {
		this.app1Queue = app1Queue;
	}
	
	@Override
	public String getApp1RoutingKey() {
		return app1RoutingKey;
	}

	public void setApp1RoutingKey(String app1RoutingKey) {
		this.app1RoutingKey = app1RoutingKey;
	}

	public String getApp2Queue() {
		return app2Queue;
	}

	public void setApp2Queue(String app2Queue) {
		this.app2Queue = app2Queue;
	}

	@Override
	public String getApp2RoutingKey() {
		return app2RoutingKey;
	}

	public void setApp2RoutingKey(String app2RoutingKey) {
		this.app2RoutingKey = app2RoutingKey;
	}

	@Override
	public int getAge() {
		return this.age;
	}
	
}
