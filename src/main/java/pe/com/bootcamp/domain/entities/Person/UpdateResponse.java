package pe.com.bootcamp.domain.entities.Person;

import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.UnitResult;

public class UpdateResponse extends UnitResult<Person> {
	public UpdateResponse(final UnitResult<Person> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}