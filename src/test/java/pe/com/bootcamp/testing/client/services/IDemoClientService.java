package pe.com.bootcamp.testing.client.services;

import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.AuthenticationRequest;
import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;

public interface IDemoClientService {	
	public AuthenticationResponse Authorization(AuthenticationRequest auth);		
	public CreateResponse create(CreateRequest person);		
	public FindAllResponse findAll();
	public FindByIdentNumberResponse findByIdentNumber(String identNumber);		
	public UpdateResponse update(UpdateRequest person);	
	public DeleteByIdentNumberResponse deleteByIdentNumber(String identNumber);	
}
