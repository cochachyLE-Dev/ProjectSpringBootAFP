package pe.com.bootcamp.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.data.interfaces.IContributionData;
import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

@Repository
public class ContributionData implements IContributionData {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<Contribution> contributons = new ArrayList<Contribution>();
	
	public ContributionData() {
		getDataDemo(); // Test		
	}
	
	private void getDataDemo(){
//		contributons.add(Contribution.builder()
//				.affiliateCode("540551LCCHM2")
//				.cumulativeContributions(17000.00)
//				.withdrawalsAndAccruedFees(19000.00)
//				.accumulatedProfitability(4000.00)
//				.accumulatedFund(2000.00)
//				.build());
	}
	
	public Contribution GetContributionByAffiliateCode(String affiliateCode) {
		return contributons.stream().findFirst().get();//.filter(c -> c.getAffiliateCode() == affiliateCode).collect(Collectors.toList()).get(1);
	}

	@Override
	public ResultBase create(Contribution contribution) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Contribution> findAll() {
		UnitResult<Contribution> result = new UnitResult<Contribution>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Contribution> findByAffiliateCode(String affiliateCode) {
		UnitResult<Contribution> result = new UnitResult<Contribution>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public UnitResult<Contribution> update(Contribution contribution) {
		UnitResult<Contribution> result = new UnitResult<Contribution>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public ResultBase deleteByAffiliateCode(String affiliateCode) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
}
