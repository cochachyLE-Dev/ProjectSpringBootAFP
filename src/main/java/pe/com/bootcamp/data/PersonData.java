package pe.com.bootcamp.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.com.bootcamp.data.interfaces.IPersonData;
import pe.com.bootcamp.data.repositories.IPersonRepository;
import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

@AllArgsConstructor
@Service
public class PersonData implements IPersonData {

	@PersistenceContext
    EntityManager entityManager;
	
	@Autowired
	private IPersonRepository personRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<Person> persons = new ArrayList<Person>();			
	
	public Person GetPersonByIdentNumber(String identNumber) {
		return persons.stream().findFirst().get();//.filter(c -> c.getIdentificationNumber() == identNumber).findFirst().get();
	}
	
	public void getDataDemo(){		
		persons.add(Person.builder()
				.typeOfIdentityDocument("DNI")				
				.identificationNumber("47720848")
				.firstName("Luis Eduardo")
				.lastName("Cochachi Chamorro")
				.dateOfBirth(LocalDate.parse("1993-05-03"))
				//.affiliateCode("540551LCCHM2")				
				//.affiliate(new AffiliateData().GetAffiliateByCode("540551LCCHM2"))
				.build());
	}

	@Override
	@Transactional
	public ResultBase create(Person person) {
		ResultBase result = new ResultBase();
		try {
			logger.info("Creating person:" + person.toString());
			
			if(!ExistsPerson(person.getTypeOfIdentityDocument(), person.getIdentificationNumber()))
			{			
				String query = "Insert into Person(type_of_identity_document,identification_number,first_name,last_name) values (:typeOfIdentityDocument,:identificationNumber,:firstName,:lastName)";
				
				entityManager.createNativeQuery(query)
				.setParameter("typeOfIdentityDocument", person.getTypeOfIdentityDocument())
				.setParameter("identificationNumber", person.getIdentificationNumber())
				.setParameter("firstName", person.getFirstName())
				.setParameter("lastName", person.getLastName())
				.executeUpdate();					
				
				result.setMessage("Created person successful");
				logger.info(result.getMessage());
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
	public UnitResult<Person> findByIdentNumber(String identNumber) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Person> update(Person person) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			personRepository.save(person);
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public ResultBase deleteByIdentNumber(String identNumber) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@Transactional
	public boolean ExistsPerson(String typeOfIdentityDocument ,String identificationNumber) {
		try
		{
			String query = "SELECT type_of_identity_document,identification_number,first_name,last_name FROM Person where type_of_identity_document = :typeOfIdentityDocument and identification_number = :identificationNumber";
			List<?> persons = entityManager.createNativeQuery(query)
					.setParameter("typeOfIdentityDocument", typeOfIdentityDocument)
					.setParameter("identificationNumber", identificationNumber)
					.getResultList();
			
			if(!persons.isEmpty() && persons.size() > 0)
			{
				logger.error("Person Exists:"+persons.get(0).toString());
			}
			
			return !persons.isEmpty() && persons.size() > 0;
		}catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
}
