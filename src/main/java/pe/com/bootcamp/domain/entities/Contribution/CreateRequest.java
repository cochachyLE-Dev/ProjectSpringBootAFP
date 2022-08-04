package pe.com.bootcamp.domain.entities.Contribution;

import pe.com.bootcamp.entities.Contribution;

public class CreateRequest extends Contribution {

	public CreateRequest(String affiliateCode, Double cumulativeContributions, Double withdrawalsAndAccruedFees,
			Double accumulatedProfitability, Double accumulatedFund) {
		super(affiliateCode, cumulativeContributions, withdrawalsAndAccruedFees, accumulatedProfitability, accumulatedFund);		
	}
	
	public Contribution copy() throws CloneNotSupportedException {
		return (Contribution) super.clone();
	}
}
