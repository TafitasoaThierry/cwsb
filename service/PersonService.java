package com.ht.service;

import com.ht.model.Person;
import com.ht.repository.PersonRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person addPerson(Person newPerson) {
		return this.personRepository.save(newPerson);
	}

	public List<Person> getPersonList() {
		return this.personRepository.findAll();
	}

	public String deletePerson(Long id) {
		if(this.personRepository.findById(id).isPresent()) {
			this.personRepository.deleteById(id);
			return "person deleted";
		}else {
			return id.toString() + " isn't in person list";
		}
	}

	public Person updatePerson(Long id, Person newPersonInfo) {
		if(this.personRepository.findById(id).isPresent()) {
			Person personInfo = this.personRepository.findById(id).get();
			personInfo.setName(newPersonInfo.getName());
			personInfo.setSurname(newPersonInfo.getSurname());
			personInfo.setAge(newPersonInfo.getAge());
			personInfo.setAdress(newPersonInfo.getAdress());
			return this.personRepository.save(personInfo);
		}else {
			throw new ELException(id.toString() + " isn't in person list");
		}
	}
}
