package pe.com.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.controllers.interfaces.IPersonController;
import pe.com.bootcamp.data.PersonData;
import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;
import pe.com.bootcamp.entities.Person;

@RestController
@RequestMapping(path = "/person")
public class PersonController implements IPersonController {
	
	@Autowired
	public PersonData personData;

	@Override
	public CreateResponse create(CreateRequest person) throws CloneNotSupportedException {
		return new CreateResponse(personData.create(
				Person.builder()
				.typeOfIdentityDocument(person.getTypeOfIdentityDocument())
				.identificationNumber(person.getIdentificationNumber())
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.dateOfBirth(person.getDateOfBirth())
				.maritalStatus(person.getMaritalStatus())
				.ubigeo(person.getUbigeo())
				.nationatity(person.getNationatity())
				.build()));
	}

	@Override
	public FindAllResponse findAll() {
		return new FindAllResponse(personData.findAll());
	}

	@Override
	public FindByIdentNumberResponse findByIdentNumber(String identNumber) {
		return new FindByIdentNumberResponse(personData.findByIdentNumber(identNumber));
	}

	@Override
	public UpdateResponse update(UpdateRequest person) throws CloneNotSupportedException {
		return new UpdateResponse(personData.update(person.copy()));
	}

	@Override
	public DeleteByIdentNumberResponse deleteByIdentNumber(String identNumber) {
		return new DeleteByIdentNumberResponse(personData.deleteByIdentNumber(identNumber)); 
	}		
}