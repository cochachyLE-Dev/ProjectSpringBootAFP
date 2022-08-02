package pe.com.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.data.PersonData;
import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.ResultBase;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
	
	@Autowired
	public PersonData personData;
	
	@PostMapping(path="/", produces = "application/json")
	public ResultBase create(Person person) {					
		return personData.Create(person);  
	}	
}