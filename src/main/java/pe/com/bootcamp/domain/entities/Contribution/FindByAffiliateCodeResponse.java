package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.utilities.UnitResult;

public class FindByAffiliateCodeResponse extends UnitResult<Contribution> {
	public FindByAffiliateCodeResponse(final UnitResult<Contribution> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}