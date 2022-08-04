package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.entities.Contribution;

public class UpdateRequest extends Contribution {
	
	public UpdateRequest(String affiliateCode, Double cumulativeContributions, Double withdrawalsAndAccruedFees,
			Double accumulatedProfitability, Double accumulatedFund) {
		super(affiliateCode, cumulativeContributions, withdrawalsAndAccruedFees, accumulatedProfitability, accumulatedFund);
	}

	public Contribution copy() throws CloneNotSupportedException {
		return (Contribution) super.clone();
	}
}
