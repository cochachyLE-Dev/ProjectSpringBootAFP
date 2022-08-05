package pe.com.bootcamp.testing.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.com.bootcamp.data.PersonData;
import pe.com.bootcamp.data.repositories.IPersonRepository;

@ExtendWith(MockitoExtension.class)

// Unit Testing of Service Class
class PersonServiceTest {

	@Mock 
	private IPersonRepository personRepository;
	
	private PersonData personService;
	
	@BeforeEach 
	void setUp() {
        this.personService = new PersonData(this.personRepository);
    }
	
	@Test
	void findAll() {
		this.personService.findAll();
		verify(personRepository).findAll();
	}

}
