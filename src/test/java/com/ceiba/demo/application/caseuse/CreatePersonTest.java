package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.builder.PersonCommandTestDataBuilder;
import com.ceiba.demo.builder.PersonTestDataBuilder;
import com.ceiba.demo.application.command.PersonCommand;
import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.MessageSender;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;


public class CreatePersonTest {


    private CreatePerson createPerson;

    @Mock
    private MessageSender messageSender;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.createPerson = new CreatePerson(messageSender);
    }

    @Test
    public void create(){
        //arrange
        Person person = new PersonTestDataBuilder().build();
        PersonCommand personCommand = new PersonCommandTestDataBuilder().withName("felipe").build();
        doNothing().when(this.messageSender).sendMessageAdult(person);
        //act
        Person personResponse = this.createPerson.create(personCommand);
        //assert
        Assert.assertEquals(personResponse.getName(), "felipe");
    }
}
