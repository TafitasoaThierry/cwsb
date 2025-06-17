package com.ht.controller;

import java.util.List;

import com.ht.model.Person;
import com.ht.service.PersonService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PersonController {
	final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	/*
	 * use Person service
	 */
	@PostMapping("/addPerson")
	public ResponseEntity<Person> addPerson(@RequestBody Person newPerson) {
		return ResponseEntity.ok(this.personService.addPerson(newPerson));
	}

	@GetMapping("/getPersonList")
	public ResponseEntity<List<Person>> getpersonList() {
		return ResponseEntity.ok(this.personService.getPersonList());
	}

	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Long id) {
		return ResponseEntity.ok(this.personService.deletePerson(id));
	}

	@PutMapping("/updatePerson/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person newPersonInfo) {
		return ResponseEntity.ok(this.personService.updatePerson(id, newPersonInfo));
	}
}
