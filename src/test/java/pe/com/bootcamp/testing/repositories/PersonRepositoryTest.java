package pe.com.bootcamp.testing.repositories;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.com.bootcamp.data.repositories.IPersonRepository;
import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.entities.PersonPK;
import pe.com.bootcamp.utilities.ResultBase;

@SpringBootTest
// Unit Testing of Repository Class
public class PersonRepositoryTest {

	@Autowired
	private IPersonRepository personRepository;
	
	@Test
	public void createTest() {
		// Parameters
		Person person = Person.builder()
				.typeOfIdentityDocument("DNI")
				.identificationNumber("47720854")
				.firstName("Luis Eduardo")
				.lastName("Cochachi Chamorro")
				.dateOfBirth(LocalDate.parse("2022-08-04"))
				.maritalStatus("Soltero")
				.ubigeo("123456")
				.nationatity("PERU")
				.build();
		
		ResultBase result = new ResultBase();
		try {						
			if(!personRepository.existsById(new PersonPK(person.getTypeOfIdentityDocument(), person.getIdentificationNumber())))
			{	
				personRepository.save(person);									
				result.setMessage("Successful created");	
				
				Boolean actualResult = personRepository.existsById(new PersonPK(person.getTypeOfIdentityDocument(), person.getIdentificationNumber()));
				assertTrue(actualResult);
			}
			else
			{
				result.setIbException(true);
				result.setMessage("Person exists!");
			}
		}catch (Exception e) {			
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		
		assertFalse(result.isIbException());
	}

}
