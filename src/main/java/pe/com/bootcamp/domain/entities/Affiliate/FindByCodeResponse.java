package pe.com.bootcamp.domain.entities.Affiliate;

import pe.com.bootcamp.entities.Affiliate;
import pe.com.bootcamp.utilities.UnitResult;

public class FindByCodeResponse extends UnitResult<Affiliate> {
	public FindByCodeResponse(final UnitResult<Affiliate> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}
