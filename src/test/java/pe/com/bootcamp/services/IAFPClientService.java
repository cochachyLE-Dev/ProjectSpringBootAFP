package pe.com.bootcamp.services;

import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;

public interface IAFPClientService {	
	public AuthenticationResponse Authorization(String user, String password);		
	public CreateResponse create(CreateRequest person);		
	public FindAllResponse findAll();
	public FindByIdentNumberResponse findByIdentNumber(String identNumber);		
	public UpdateResponse update(UpdateRequest person);	
	public DeleteByIdentNumberResponse deleteByIdentNumber(String identNumber);	
}
