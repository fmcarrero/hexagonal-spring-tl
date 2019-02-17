package com.ceiba.demo.domain.ports;

import com.ceiba.demo.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    /**
     * metodo que lista todas las personas
     * @return List<Person> con todas las personas almacenadas
     */
    List<Person> findAll();

    /**
     * metodo encargado de buscar una persona por su id
     * @param id
     * @return  Optional<Person> con el  id
     */
    Optional<Person> findById(long id);

    /**
     * metodo que almacena una nueva persona
     * @param person
     * @return person
     */
    Person save(Person person);
}
