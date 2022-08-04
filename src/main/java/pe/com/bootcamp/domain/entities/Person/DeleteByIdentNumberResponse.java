package pe.com.bootcamp.domain.entities.Person;

import lombok.AllArgsConstructor;
import pe.com.bootcamp.utilities.ResultBase;

@AllArgsConstructor
public class DeleteByIdentNumberResponse extends ResultBase {	
	public DeleteByIdentNumberResponse(final ResultBase result) {
		super(result.isIbException(), result.getMessage());
	}
}