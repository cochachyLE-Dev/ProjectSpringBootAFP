package pe.com.bootcamp.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.data.interfaces.IAffiliateData;
import pe.com.bootcamp.domain.entities.ConsultAffiliateRequest;
import pe.com.bootcamp.domain.entities.ConsultAffiliateResponse;
import pe.com.bootcamp.domain.entities.ConsultContributionsRequest;
import pe.com.bootcamp.domain.entities.ConsultContributionsResponse;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundRequest;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundResponse;
import pe.com.bootcamp.entities.Affiliate;
import pe.com.bootcamp.entities.Contribution;
import pe.com.bootcamp.entities.Person;
import pe.com.bootcamp.utilities.ResultBase;
import pe.com.bootcamp.utilities.UnitResult;

@Repository
public class AffiliateData implements IAffiliateData {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<Affiliate> affiliates = new ArrayList<Affiliate>();
	
	public AffiliateData(){
		getDataDemo();
	}
	@Override
	public ResultBase create(Affiliate affiliate) {
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
	public UnitResult<Affiliate> findAll() {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	@Override
	public UnitResult<Affiliate> findByCode(String identNumber) {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	@Override
	public UnitResult<Affiliate> update(Affiliate affiliate) {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	@Override
	public ResultBase deleteByCode(String identNumber) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	public WithdrawalOfFundResponse requestForWithdrawalOfFund(WithdrawalOfFundRequest request) {
		WithdrawalOfFundResponse response = new WithdrawalOfFundResponse();
		
		try {
			logger.info("WithdrawalOfFundRequest:" + request.getIdentificationNumber());
			Person person = new Person();//new PersonData().GetPersonByIdentNumber(request.getIdentificationNumber());
			logger.info("GetPersonByIdentNumber:" + person.toString());
			Contribution contribution = new Contribution(); //person.getAffiliate().getContribution();
			
			if(request.getAmount() > contribution.getAccumulatedFund())
			{
				response.setIbException(true);
				response.setMessage("No se puede registrar solicitud. Monto mayor que el permitido");
			}
			else if(request.getAmount() > contribution.getAccumulatedFund() / 2)
			{
				response.setIbException(true);
				response.setMessage("Monto mínimo no cubierto por favor revise monto mínimo a retirar");
			}else
			{		
				// Register withdrawal request
				// ...
				response.setMessage("Successful process");
			}			
			
		}catch (Exception e) {
			response.setIbException(true);
			response.setMessage(e.getMessage());
			
			logger.warn("Exception-Message:" + e.getMessage());
			logger.warn("Exception-Cause:" + e.getCause());
		}
		return response; 
	}
	
	public ConsultAffiliateResponse ConsultAffiliateByCode(ConsultAffiliateRequest request) {
		ConsultAffiliateResponse response = new ConsultAffiliateResponse();
		try {			
			Affiliate affiliateData = GetAffiliateByCode(request.getAffiliateCode());
			response.setValue(affiliateData);
		}catch (Exception e) {
			response.setIbException(true);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	public ConsultContributionsResponse ConsultContributionsByAffiliateCode(ConsultContributionsRequest request) {
		ConsultContributionsResponse response = new ConsultContributionsResponse();
		try {
			Contribution contributionData = new ContributionData().GetContributionByAffiliateCode(request.getAffiliateCode());
			response.setValue(contributionData);
		}catch (Exception e) {
			logger.error(e.getMessage());
			response.setIbException(true);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public Affiliate GetAffiliateByCode(String affiliateCode) {
		return affiliates.stream().findFirst().get();//.filter(c -> c.getCode() == affiliateCode).findFirst().get();		
	}
	
	private void getDataDemo(){		
//		affiliates.add(Affiliate.builder()
//				.code("540551LCCHM2")
//				.origen("HABITAT")
//				.typeOfWorker("Dependent")
//				.currentAFP("HABITAT")
//				.status("Active")
//				.contribution(new ContributionData().GetContributionByAffiliateCode("540551LCCHM2"))
//				.build());
	}
}
