package pe.com.bootcamp.data;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.com.bootcamp.data.interfaces.IPersonData;
import pe.com.bootcamp.data.repositories.IPersonRepository;
import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.entities.PersonPK;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

@AllArgsConstructor
@Service
public class PersonData implements IPersonData {
	
	@Autowired
	private final IPersonRepository personRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());			
		
	@Override
	@Transactional
	public ResultBase create(Person person) {
		ResultBase result = new ResultBase();
		try {
			logger.info("Creating person:" + person.toString());
			
			if(!personRepository.existsById(new PersonPK(person.getTypeOfIdentityDocument(), person.getIdentificationNumber())))
			{	
				personRepository.save(person);									
				result.setMessage("Successful created");				
			}
			else
			{
				result.setIbException(true);
				result.setMessage("Person exists!");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Person> findAll() {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			result.setList(new ArrayList<Person>(personRepository.findAll()));
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Person> findByIdentNumber(String typeOfIdentityDocument, String identificationNumber) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			Optional<Person> value = personRepository.findById(new PersonPK(typeOfIdentityDocument,identificationNumber));
			if(!value.isEmpty())
				result.setValue(value.get());
			else
			{
				result.setIbException(true);
				result.setMessage("Not found");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	@Transactional
	public UnitResult<Person> update(Person person) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			PersonPK personPK = new PersonPK(person.getTypeOfIdentityDocument(), person.getIdentificationNumber());
			if(personRepository.existsById(personPK))
			{
				Person update = personRepository.findById(personPK).get();
				update.setFirstName(person.getFirstName());
				update.setLastName(person.getLastName());
				update.setMaritalStatus(person.getMaritalStatus());
				update.setNationatity(person.getNationatity());
				update.setUbigeo(person.getUbigeo());
				
				personRepository.save(update);
				result.setMessage("successfully updated");
			}else {
				result.setIbException(true);
				result.setMessage("Not found");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	@Transactional
	public ResultBase deleteByIdentNumber(String typeOfIdentityDocument, String identificationNumber) {
		ResultBase result = new ResultBase();
		try {
			if(personRepository.existsById(new PersonPK(typeOfIdentityDocument,identificationNumber)))
			{				
				personRepository.deleteById(new PersonPK(typeOfIdentityDocument, identificationNumber));
				result.setMessage("successfully removed");
			}else {
				result.setIbException(true);
				result.setMessage("Not found");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}	
}
