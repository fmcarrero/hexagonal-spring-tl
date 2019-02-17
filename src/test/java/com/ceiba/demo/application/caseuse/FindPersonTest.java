package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.builder.PersonTestDataBuilder;
import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
public class FindPersonTest {

    private FindPerson findPerson;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setup (){
        MockitoAnnotations.initMocks(this);
        this.findPerson = new FindPerson(personRepository);
    }

    @Test
    public void findAllTest(){
        //arrange
        List<Person> people = new ArrayList<>();
        people.add(new PersonTestDataBuilder().withName("jose").build());
        people.add(new PersonTestDataBuilder().withName("andrea").build());
        when(this.personRepository.findAll()).thenReturn(people);
        //act
        List<Person> peopleResponse = this.findPerson.findAll();
        //assert
        Assert.assertEquals(people.size(), peopleResponse.size());
        Assert.assertEquals(people.get(0).getName(), "jose" );
        Assert.assertEquals(people.get(1).getName(), "andrea" );
    }

    @Test
    public void findById(){
        //arrange
        int id = 5;
        Person person = new PersonTestDataBuilder().withId(id).build();
        Optional<Person> PersonOptional = Optional.of(person);
        when(this.personRepository.findById(id)).thenReturn(PersonOptional);
        //act
        Optional<Person> personResponse = this.findPerson.findById(person.getId());
        //assert
        Assert.assertEquals(personResponse.get().getId(),id);
    }

}
