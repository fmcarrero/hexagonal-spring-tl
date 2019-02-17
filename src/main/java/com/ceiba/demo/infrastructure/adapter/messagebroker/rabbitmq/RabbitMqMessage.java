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
    private final int limitAge;

    @Autowired
    public RabbitMqMessage(RabbitTemplate rabbitTemplate , ApplicationConfigReader applicationConfigReader){
        this.rabbitTemplate = rabbitTemplate;
        this.applicationConfigReader = applicationConfigReader;
        this.limitAge = applicationConfigReader.getAge();
    }

    @Override
    public void sendMessage(Person person) {
        String exchange = this.applicationConfigReader.getAppExchange();
        String routingKey = this.applicationConfigReader.getApp1RoutingKey();
        if(isAdult(person.getAge()) ){
            routingKey = this.applicationConfigReader.getApp2RoutingKey();
        }
        this.rabbitTemplate.convertAndSend(exchange, routingKey, person);
    }

    private boolean isAdult(int age){

        if (age > this.limitAge){
            return true;
        }
        return false;
    }
}
