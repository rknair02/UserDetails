package com.abn.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abn.db.entity.Person;
import com.abn.db.springdatabase.PersonSpringDataRepository;
import com.abn.error.DateNotValidException;
import com.abn.error.EmailNotvalidException;
import com.abn.error.PersonNotFoundException;
import com.abn.validate.DateValidator;

@RestController
public class UserController {

	@Autowired
	PersonSpringDataRepository repository;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	//get all users
	@GetMapping(value = "/users")
	public List<Person> handleViewUsersRequest(ModelMap model) {
		logger.info("api view all info invoked");
		return repository.findAll();
	}

	// get specific user
	@GetMapping("/user/{Id}")
	Person findOne(@PathVariable int Id) {
		return repository.findById(Id).orElseThrow(() -> new PersonNotFoundException(Id));
	}
	
	//send status as created and add a user, validation for email and DOB
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/user/add")
	Person handleUserInsert(@Valid @RequestBody Person person) {
		DateValidator valid = new DateValidator();
		if (EmailValidator.getInstance().isValid(person.getEmail()))
			if (valid.isThisDateValid(person.getBirthDate(),"MM/dd/yyyy"))
				return repository.save(person);
			else
				throw new DateNotValidException(person.getBirthDate());
		else
			throw new EmailNotvalidException(person.getEmail());

	}

	//update a user if not existing otherwise create
	@PutMapping(value = "user/{id}")
	Person saveOrUpdate(@RequestBody Person person, @PathVariable int id) {

		return repository.findById(id).map(x -> {
			x.setFirst_name(person.getFirst_name());
			x.setLast_name(person.getLast_name());
			x.setBirthDate(person.getBirthDate());
			x.setGender(person.getGender());
			x.setEmail(person.getEmail());
			x.setCreation_datetime(person.getCreation_datetime());
			return repository.save(x);
		}).orElseGet(() -> {
			person.setId(id);
			return repository.save(person);
		});
	}

	@DeleteMapping("/user/{id}")
	void deleteuser(@PathVariable int id) {
		repository.deleteById(id);
	}
}
