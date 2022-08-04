package pe.com.bootcamp.data.interfaces;

import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

public interface IContributionData {
	public ResultBase create(Contribution contribution);
	public UnitResult<Contribution> findAll();
	public UnitResult<Contribution> findByAffiliateCode(String affiliateCode);
	public UnitResult<Contribution> update(Contribution contribution);
	public ResultBase deleteByAffiliateCode(String affiliateCode);	
}
