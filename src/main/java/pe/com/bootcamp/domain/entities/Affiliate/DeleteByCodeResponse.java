package pe.com.bootcamp.domain.entities.Affiliate;

import pe.com.bootcamp.utilities.ResultBase;

public class DeleteByCodeResponse extends ResultBase {	
	public DeleteByCodeResponse(final ResultBase result) {
		super(result.isIbException(), result.getMessage());
	}
}
