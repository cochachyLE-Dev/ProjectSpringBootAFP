package pe.com.bootcamp.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
public class AffiliateData {

	public List<Affiliate> affiliates = new ArrayList<Affiliate>();
	
	public AffiliateData(){
		getDataDemo();
	}
	
	public ResultBase Create(Affiliate affiliate) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Affiliate> FindAll() {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Affiliate> findByIdentNumber(String identNumber) {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public UnitResult<Affiliate> Update(Affiliate affiliate) {
		UnitResult<Affiliate> result = new UnitResult<Affiliate>();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	public ResultBase Delete(String numIdent) {
		ResultBase result = new ResultBase();
		try {
			
		}catch (Exception e) {
			result.setIbException(true);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	public WithdrawalOfFundResponse requestForWithdrawalOfFund(WithdrawalOfFundRequest request) {
		WithdrawalOfFundResponse response = new WithdrawalOfFundResponse();
		
		try {
			Person person = new PersonData().GetPersonByIdentNumber(request.getIdentificationNumber());
			Contribution contribution = person.getAffiliate().getContribution();
			
			if(request.getAmount() > contribution.getAccumulatedFund())
			{
				response.setIbException(true);
				response.setMessage("No se puede registrar solicitud. Monto mayor que el permitido");
			}
			else if(request.getAmount() > contribution.getAccumulatedFund() / 2)
			{
				response.setIbException(true);
				response.setMessage("Monto mínimo no cubierto por favor revise monto mínimo a retirar");
			}
			
			// Register withdrawal request
			// ...
			response.setMessage("Successful process");
			
		}catch (Exception e) {
			response.setIbException(true);
			response.setMessage(e.getMessage());
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
			response.setIbException(true);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public Affiliate GetAffiliateByCode(String affiliateCode) {
		return affiliates.stream().filter(c -> c.getCode() == affiliateCode).findFirst().get();
	}
	
	private void getDataDemo(){		
		affiliates.add(Affiliate.builder()
				.code("540551LCCHM2")
				.origen("HABITAT")
				.typeOfWorker("Dependent")
				.currentAFP("HABITAT")
				.status("Active")
				.contribution(new ContributionData().GetContributionByAffiliateCode("540551LCCHM2"))
				.build());
	}
}
