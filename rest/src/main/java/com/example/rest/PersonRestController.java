package com.example.rest;

import com.example.core.domain.Person;
import com.example.core.ports.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonRestController {

    private People peopleService;

    @Autowired
    public PersonRestController(People peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> readPeople() {
        return peopleService.readPeople();
    }

    @GetMapping("{id}")
    public Person readPerson(@PathVariable Long id) {
        return peopleService.readPerson(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@Valid @RequestBody Person person) {
        return peopleService.createPerson(person);
    }
}
