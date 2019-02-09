package com.example.core.unit.adapters;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.core.adapters.PersonAdapter;
import com.example.core.adapters.PersonMaker;
import com.example.core.domain.Adult;
import com.example.core.domain.Person;
import com.example.core.ports.ApplicationConfigReader;
import com.example.core.ports.MessageSender;
import com.example.core.ports.PersonRepository;
import com.example.data.builder.AdultTestDataBuilder;


public class PersonAdapterTest {

	private PersonAdapter personAdapter;
	
	@Mock
	private PersonRepository personRepository;
	
	@Mock
	private ApplicationConfigReader applicationConfig;
	@Mock
	private MessageSender messageSender;
	@Mock
	private PersonMaker personMaker;
	
	
	 
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.personAdapter = new PersonAdapter(personRepository,personMaker, messageSender,applicationConfig);
	}
	@Test
	public void readPeopleTest() {
		int age = 89;
		String name ="jose";
		List<Person> people = new ArrayList<>();
		Person person = new AdultTestDataBuilder().withName(name).withAge(age).build();	
		people.add(person);
		when(this.personRepository.findAll()).thenReturn(people);
		// Act		
		List<Person> peopleResponse = this.personAdapter.readPeople();
		// Assert
		Assert.assertEquals(peopleResponse.size(), 1);	
		Assert.assertEquals(peopleResponse.get(0).getAge(), age);	
		Assert.assertEquals(peopleResponse.get(0).getName(), name);	
	}
	
	@Test
	public void readPersonTest() {
		//arrage
		int age = 89;
		String lastName ="carrero";		
		Person person = new AdultTestDataBuilder().withlastName(lastName).withAge(age).build();			
		Optional<Person> PersonOptional = Optional.of(person);
		when(this.personRepository.findById(person.getId())).thenReturn(PersonOptional);
		// Act		
		Optional<Person> peopleResponse = this.personAdapter.readPerson(person.getId());
		// Assert	
		Assert.assertEquals(peopleResponse.get().getAge(), age);	
		Assert.assertEquals(peopleResponse.get().getLastName(), lastName);	
	}
	
	@Test
	public void createPersonTest() {
		//arrange
		int age = 89;
		String AppRoutingKey = "app1";
		String AppExchange = "app1exchange";
		String lastName ="carrero";		
	
		Adult person = (Adult) new AdultTestDataBuilder().withlastName(lastName).withAge(age).build();	
		person.setAppRoutingKey(AppRoutingKey);
		when(this.personMaker.makeFactoryPerson(person)).thenReturn(person);
		when(this.applicationConfig.getApp1Exchange()).thenReturn(AppExchange);
		doNothing().when(this.messageSender).sendMessage(AppExchange,AppRoutingKey,person);
		//act
		this.personAdapter.createPerson(person);
		//assert
		verify(this.messageSender).sendMessage(AppExchange,AppRoutingKey,person);
	}
}
