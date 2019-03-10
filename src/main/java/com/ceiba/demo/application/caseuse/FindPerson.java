package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.domain.exception.NotFoundPersonException;
import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.PersonRepository;
import java.util.List;

public class FindPerson {

	 /**
     * Useful for {NotFoundException } operations, which return when an person is
     * not found.
     */
    public final String NOT_FOUND_PERSON = "Persona no encontrada";
    
	private PersonRepository personRepository;

 
    public FindPerson(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundPersonException(this.NOT_FOUND_PERSON));
    }

}
