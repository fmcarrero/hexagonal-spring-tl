package com.ceiba.demo.domain.ports;

import com.ceiba.demo.domain.model.Person;

public interface MessageSender {
    /**
     * Método que se encarga de enviar el mensaje
     * @param person El parámetro person es el objeto a almacenar en la cola
     */
    void sendMessage( Person person);
}
