package com.ceiba.demo.infrastructure.adapter.controller.springcontroller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.demo.application.caseuse.CreatePerson;
import com.ceiba.demo.application.caseuse.FindPerson;
import com.ceiba.demo.application.command.PersonCommand;
import com.ceiba.demo.domain.model.Person;

@RestController
@RequestMapping("/people")
public class PersonRestController {

	private CreatePerson peopleService;
	private FindPerson findPerson;

	
	public PersonRestController(CreatePerson peopleService,FindPerson findPerson){
		this.peopleService= peopleService;
		this.findPerson = findPerson;
	}

	@GetMapping
	public List<Person> read() {
		return findPerson.findAll();
	}

	@GetMapping("{id}")
	public Person read(@PathVariable long id) {
		return findPerson.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create( @RequestBody PersonCommand personCommand) {
		return peopleService.create(personCommand);
	}
}
