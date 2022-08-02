package pe.com.bootcamp.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

@Repository
public class PersonData {

	public List<Person> persons = new ArrayList<Person>();
	
	public PersonData() {
		getDataDemo();
	}
	
	public ResultBase Create(Person person) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Person> FindAll() {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Person> FindId(String numIdent) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Person> Update(Person person) {
		UnitResult<Person> result = new UnitResult<Person>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public ResultBase Delete(String numIdent) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
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
				.affiliateCode("540551LCCHM2")				
				.affiliate(new AffiliateData().GetAffiliateByCode("540551LCCHM2"))
				.build());
	}
}
