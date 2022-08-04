package pe.com.bootcamp.data.interfaces;

import pe.com.bootcamp.entities.Affiliate;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

public interface IAffiliateData {

	public ResultBase create(Affiliate affiliate);
	public UnitResult<Affiliate> findAll();
	public UnitResult<Affiliate> findByCode(String affiliateCode);
	public UnitResult<Affiliate> update(Affiliate affiliate);
	public ResultBase deleteByCode(String affiliateCode);
	
}
