package pe.com.bootcamp.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Contribution {
	@Getter @Setter
	public String affiliateCode;
	@Getter @Setter
	public Double cumulativeContributions;
	@Getter @Setter
	public Double withdrawalsAndAccruedFees;
	@Getter @Setter
	public Double accumulatedProfitability;
	@Getter @Setter
	public Double accumulatedFund;	
}
