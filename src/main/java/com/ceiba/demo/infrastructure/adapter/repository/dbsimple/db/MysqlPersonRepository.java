package com.ceiba.demo.infrastructure.adapter.repository.dbsimple.db;

import com.ceiba.demo.domain.model.Person;
import com.ceiba.demo.domain.ports.PersonRepository;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.mapper.JpaPersonMapper;
import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jpaentity.JpaPerson;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.demo.infrastructure.adapter.repository.dbsimple.jparepository.JpaPersonRepository;

public class MysqlPersonRepository implements PersonRepository {

    private JpaPersonRepository jpaPersonRepository;

    @Autowired
    public MysqlPersonRepository (JpaPersonRepository jpaPersonRepository){
        this.jpaPersonRepository =jpaPersonRepository ;
    }

    public List<Person> findAll() {
        return JpaPersonMapper.MAPPER.toPeople(jpaPersonRepository.findAll());
    }

    
    public Optional<Person> findById(long id) {
        return Optional.ofNullable(JpaPersonMapper.MAPPER.toPerson(jpaPersonRepository.findById(id).orElse(null)));
    }

    public Person save(Person person) {
        JpaPerson jpaPerson = JpaPersonMapper.MAPPER.toJpaPerson(person);
        return jpaPersonRepository.save(jpaPerson);
    }
}
