package com.example.jpa;

import com.example.core.domain.Person;
import com.example.core.ports.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private JpaPersonRepository jpaPersonRepository;

    @Override
    public List<Person> findAll() {
        return JpaPersonMapper.MAPPER.toPeople(jpaPersonRepository.findAll());
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.of(JpaPersonMapper.MAPPER.toPerson(jpaPersonRepository.findById(id).orElse(null)));
    }

    @Override
    public Person save(Person person) {
        return jpaPersonRepository.save(JpaPersonMapper.MAPPER.toJpaPerson(person));
    }
}
