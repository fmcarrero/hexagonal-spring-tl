package com.example.rest;

import com.example.core.constants.PersonConstants;
import com.example.core.domain.Person;
import com.example.core.exception.NotFoundException;
import com.example.core.ports.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonRestController {

	@Autowired
	private People peopleService;

	@GetMapping
	public List<Person> readPeople() {
		return peopleService.readPeople();
	}

	@GetMapping("{id}")
	public Person readPerson(@PathVariable Long id) {
		return peopleService.readPerson(id).orElseThrow(() -> new NotFoundException(PersonConstants.NOT_FOUND_PERSON));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person createPerson(@Valid @RequestBody Person person) {
		return peopleService.createPerson(person);
	}
}
