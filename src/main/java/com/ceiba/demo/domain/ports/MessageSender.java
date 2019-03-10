package com.ceiba.demo.domain.ports;

import com.ceiba.demo.domain.model.Person;

public interface MessageSender {
    
	/**
     * Método que se encarga de enviar el mensaje cuando una persona es adulta
     * @param person El parámetro person es el objeto a almacenar en la cola
     */
    void sendMessageAdult( Person person);
    
    /**
     * Método que se encarga de enviar el mensaje cuando una persona es joven
     * @param person El parámetro person es el objeto a almacenar en la cola
     */
    void sendMessageYoung( Person person);
}
