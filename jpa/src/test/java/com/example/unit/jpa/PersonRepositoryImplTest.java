package com.example.unit.jpa;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.core.domain.Person;
import com.example.data.builder.AdultTestDataBuilder;
import com.example.data.builder.JpaPersonTestDataBuilder;
import com.example.jpa.JpaPersonRepository;
import com.example.jpa.PersonRepositoryImpl;
import com.example.jpa.entities.JpaPerson;


public class PersonRepositoryImplTest {

	@Mock
	JpaPersonRepository jpaPersonRepository;

	@InjectMocks
	PersonRepositoryImpl personRepositoryImpl;
	
	

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllTest() {
		int age = 89;
		List<JpaPerson> people = new ArrayList<>();
		JpaPerson jpaPerson =  new JpaPersonTestDataBuilder().withId(2).withAge(age).build();
		people.add(jpaPerson);
		when(this.jpaPersonRepository.findAll()).thenReturn(people);
		// Act		
		List<Person> peopleResponse = this.personRepositoryImpl.findAll();
		// Assert
		Assert.assertEquals(peopleResponse.size(), 1);
		Assert.assertEquals(peopleResponse.get(0).getId(), 2);
	}
	@Test
	public void findAllNullTest() {
	
		when(this.jpaPersonRepository.findAll()).thenReturn(null);
		// Act		
		List<Person> peopleResponse = this.personRepositoryImpl.findAll();
		// Assert
		Assert.assertEquals(peopleResponse, null);
		
	}
	@Test
	public void saveTest() {
		int age = 89;
		Person person = new AdultTestDataBuilder().withId(0).withAge(age).build();
		JpaPerson jpaPerson =  new JpaPersonTestDataBuilder().withId(2).withAge(age).build();
		when(this.jpaPersonRepository.save(Mockito.any(JpaPerson.class))).thenReturn(jpaPerson);
		// Act
		
		Person  personResponse = this.personRepositoryImpl.save(person);
		// Assert
		Assert.assertEquals(personResponse.getAge(), age);
		Assert.assertEquals(personResponse.getId(), 2);
	}
	
	@Test
	public void findByIdTest() {
		int age = 89;
		Person person = new AdultTestDataBuilder().withId(2).withAge(age).build();
		JpaPerson jpaPerson =  new JpaPersonTestDataBuilder().withId(2).withAge(age).build();
		Optional<JpaPerson> jpaPersonOptional = Optional.of(jpaPerson);
		when(this.jpaPersonRepository.findById(person.getId())).thenReturn(jpaPersonOptional);
		// Act
		
		Optional<Person>  personResponse = this.personRepositoryImpl.findById(person.getId());
		// Assert
		Assert.assertEquals(personResponse.get().getAge(), age);
		Assert.assertEquals(personResponse.get().getId(), 2);
	}
	@Test
	public void findByIdEmptyTest() {
		int age = 89;
		Person person = new AdultTestDataBuilder().withId(2).withAge(age).build();		
		Optional<JpaPerson> jpaPersonOptional = Optional.empty();
		when(this.jpaPersonRepository.findById(person.getId())).thenReturn(jpaPersonOptional);
		// Act		
		Optional<Person>  personResponse = this.personRepositoryImpl.findById(person.getId());
		// Assert
		Assert.assertEquals(personResponse, Optional.empty());		
	}

}
