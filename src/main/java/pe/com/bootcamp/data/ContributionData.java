package pe.com.bootcamp.data;

import java.util.ArrayList;
import java.util.List;

import pe.com.bootcamp.entities.Contribution;

public class ContributionData {

	public List<Contribution> contributons = new ArrayList<Contribution>();
	
	public ContributionData() {
		getDataDemo(); // Test		
	}
	
	private void getDataDemo(){
		contributons.add(Contribution.builder()
				.affiliateCode("540551LCCHM2")
				.cumulativeContributions(17000.00)
				.withdrawalsAndAccruedFees(19000.00)
				.accumulatedProfitability(4000.00)
				.accumulatedFund(2000.00)
				.build());
	}
	
	public Contribution GetContributionByAffiliateCode(String affiliateCode) {
		return contributons.stream().findFirst().get();//.filter(c -> c.getAffiliateCode() == affiliateCode).collect(Collectors.toList()).get(1);
	}
}
