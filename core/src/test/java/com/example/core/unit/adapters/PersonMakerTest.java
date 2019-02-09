package com.example.core.unit.adapters;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.core.adapters.PersonMaker;
import com.example.core.domain.Adult;
import com.example.core.domain.Person;
import com.example.core.domain.Young;
import com.example.core.ports.ApplicationConfigReader;
import com.example.data.builder.PersonTestDataBuilder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class PersonMakerTest {
	
	private PersonMaker  personMaker;
	
	@Mock
	private ApplicationConfigReader applicationConfig;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.personMaker = new PersonMaker(applicationConfig);
		when(this.applicationConfig.getAge()).thenReturn(18);
	}

	@Test
	public void makeFactoryPersonYoungTest() {
		//arrange
		Person person = new PersonTestDataBuilder().withAge(1).build();		
		//act
		Person young = this.personMaker.makeFactoryPerson(person);
		//assert
		assertThat(young, instanceOf(Young.class));
	}
	@Test
	public void makeFactoryPersonAdultTest() {
		//arrange
		Person person = new PersonTestDataBuilder().withAge(19).build();		
		//act
		Person adult = this.personMaker.makeFactoryPerson(person);
		//assert
		assertThat(adult, instanceOf(Adult.class));
	}
}
