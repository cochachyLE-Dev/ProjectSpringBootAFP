package pe.com.bootcamp.domain.entities.Person;

import java.time.LocalDate;

import pe.com.bootcamp.entities.Person;

public class UpdateRequest extends Person {
	
	public UpdateRequest(String typeOfIdentityDocument, String identificationNumber, String firstName, String lastName,
			LocalDate dateOfBirth, String maritalStatus, String ubigeo, String nationatity) {
		super(typeOfIdentityDocument, identificationNumber, firstName, lastName, dateOfBirth, maritalStatus, ubigeo,
				nationatity);
	}
	public Person copy() throws CloneNotSupportedException {
		return (Person) super.clone();
	}
}
