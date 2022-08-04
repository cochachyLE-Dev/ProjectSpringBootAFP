package pe.com.bootcamp.domain.entities.Person;

import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.UnitResult;

public class FindAllResponse extends UnitResult<Person> {
	public FindAllResponse(final UnitResult<Person> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}