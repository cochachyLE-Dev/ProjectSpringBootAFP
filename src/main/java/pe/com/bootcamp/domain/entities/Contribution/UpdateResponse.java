package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.utilities.UnitResult;

public class UpdateResponse extends UnitResult<Contribution> {
	public UpdateResponse(final UnitResult<Contribution> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}