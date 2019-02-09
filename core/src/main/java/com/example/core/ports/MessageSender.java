package com.example.core.ports;

public interface MessageSender {
	void sendMessage( String exchange, String routingKey, Object data);
}
