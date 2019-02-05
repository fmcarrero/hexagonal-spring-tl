package com.example.core.ports;

import com.example.core.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);
}
