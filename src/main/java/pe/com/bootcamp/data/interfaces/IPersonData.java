package pe.com.bootcamp.data.interfaces;

import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

public interface IPersonData {
	public ResultBase create(Person person);
	public UnitResult<Person> findAll();
	public UnitResult<Person> findByIdentNumber(String typeOfIdentityDocument, String identificationNumber);	
	public UnitResult<Person> update(Person person);
	public ResultBase deleteByIdentNumber(String typeOfIdentityDocument, String identificationNumber);
}