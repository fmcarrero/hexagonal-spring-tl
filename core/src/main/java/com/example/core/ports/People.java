package com.example.core.ports;

import com.example.core.domain.Person;

import java.util.List;
import java.util.Optional;

public interface People {

    List<Person> readPeople();

    Optional<Person> readPerson(Long id);

    Person createPerson(Person person);
}
