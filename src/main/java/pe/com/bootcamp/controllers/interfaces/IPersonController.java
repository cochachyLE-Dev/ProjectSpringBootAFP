package pe.com.bootcamp.controllers.interfaces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;

public interface IPersonController {
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public CreateResponse create(@RequestBody CreateRequest person) throws CloneNotSupportedException;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public FindAllResponse findAll();
	
	@GetMapping(path = "/findByCode/{identNumber}", produces = "application/json")
	public FindByIdentNumberResponse findByIdentNumber(@PathVariable String identNumber);
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public UpdateResponse update(@RequestBody UpdateRequest person) throws CloneNotSupportedException;
	
	@DeleteMapping(path = "/deleteByCode/{identNumber}", produces = "application/json")
	public DeleteByIdentNumberResponse deleteByIdentNumber(@PathVariable String identNumber);
}