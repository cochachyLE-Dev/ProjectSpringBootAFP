package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.utilities.UnitResult;

public class FindAllResponse extends UnitResult<Contribution> {
	public FindAllResponse(final UnitResult<Contribution> result) {
		super(result.getValue(), result.getList(), result.isIbException(), result.getMessage());
	}
}
