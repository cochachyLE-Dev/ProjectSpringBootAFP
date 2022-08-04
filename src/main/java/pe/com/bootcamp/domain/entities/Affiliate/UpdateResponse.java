package pe.com.bootcamp.domain.entities.Affiliate;

import pe.com.bootcamp.entities.Affiliate;
import pe.com.bootcamp.utilities.UnitResult;

public class UpdateResponse extends UnitResult<Affiliate> {
	public UpdateResponse(final UnitResult<Affiliate> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}
