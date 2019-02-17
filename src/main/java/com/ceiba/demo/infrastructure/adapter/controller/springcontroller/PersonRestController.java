package com.ceiba.demo.infrastructure.adapter.controller.springcontroller;


import com.ceiba.demo.application.caseuse.FindPerson;
import com.ceiba.demo.domain.constants.PersonConstants;
import com.ceiba.demo.domain.exception.NotFoundPersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ceiba.demo.application.caseuse.CreatePerson;
import com.ceiba.demo.domain.model.Person;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonRestController {

	private CreatePerson peopleService;
	private FindPerson findPerson;

	@Autowired
	public PersonRestController(CreatePerson peopleService,FindPerson findPerson){
		this.peopleService= peopleService;
		this.findPerson = findPerson;
	}

	@GetMapping
	public List<Person> read() {
		return findPerson.findAll();
	}

	@GetMapping("{id}")
	public Person readPerson(@PathVariable Long id) {
		return findPerson.findById(id).orElseThrow(() -> new NotFoundPersonException(PersonConstants.NOT_FOUND_PERSON));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(@Valid @RequestBody Person person) {
		return peopleService.create(person);
	}
}
