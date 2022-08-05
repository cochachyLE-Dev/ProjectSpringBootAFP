package pe.com.bootcamp.controllers.interfaces;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.bootcamp.constants.AuthorityType;
import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;

public interface IPersonController {	
	@Secured({AuthorityType.ADMIN, AuthorityType.USER})
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public CreateResponse create(@RequestBody CreateRequest person) throws CloneNotSupportedException;
	
	@Secured(AuthorityType.ADMIN)
	@GetMapping(path = "/findAll", produces = "application/json")
	public FindAllResponse findAll();
	
	@Secured({AuthorityType.ADMIN, AuthorityType.USER})
	@GetMapping(path = "/findByCode/{typeOfIdentityDocument}/{identificationNumber}", produces = "application/json")
	public FindByIdentNumberResponse findByIdentNumber(@PathVariable String typeOfIdentityDocument, @PathVariable String identificationNumber);
	
	@Secured({AuthorityType.ADMIN, AuthorityType.USER})
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public UpdateResponse update(@RequestBody UpdateRequest person) throws CloneNotSupportedException;
	
	@Secured(AuthorityType.ADMIN)
	@DeleteMapping(path = "/deleteByCode/{typeOfIdentityDocument}/{identificationNumber}", produces = "application/json")
	public DeleteByIdentNumberResponse deleteByIdentNumber(@PathVariable String typeOfIdentityDocument, @PathVariable String identificationNumber);
}