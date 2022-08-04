package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.utilities.ResultBase;

public class DeleteByAffiliateCodeResponse extends ResultBase {	
	public DeleteByAffiliateCodeResponse(final ResultBase result) {
		super(result.isIbException(), result.getMessage());
	}
}