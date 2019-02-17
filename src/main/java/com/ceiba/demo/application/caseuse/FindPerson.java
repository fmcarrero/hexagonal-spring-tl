package com.ceiba.demo.application.caseuse;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FindPerson {

    private PersonRepository personRepository;

    @Autowired
    public FindPerson(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

}
