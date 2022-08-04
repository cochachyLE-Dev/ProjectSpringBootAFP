package pe.com.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.controllers.interfaces.IAffiliateController;
import pe.com.bootcamp.data.AffiliateData;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundRequest;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundResponse;
import pe.com.bootcamp.domain.entities.Affiliate.CreateRequest;
import pe.com.bootcamp.domain.entities.Affiliate.CreateResponse;
import pe.com.bootcamp.domain.entities.Affiliate.DeleteByCodeResponse;
import pe.com.bootcamp.domain.entities.Affiliate.FindAllResponse;
import pe.com.bootcamp.domain.entities.Affiliate.FindByCodeResponse;
import pe.com.bootcamp.domain.entities.Affiliate.UpdateRequest;
import pe.com.bootcamp.domain.entities.Affiliate.UpdateResponse;

@RestController
@RequestMapping(path = "/affiliate")
public class AffiliateController implements IAffiliateController{	
	
	@Autowired
	public AffiliateData affiliateData;	

	@Override
	public CreateResponse create(CreateRequest affiliate) throws CloneNotSupportedException {
		return new CreateResponse(affiliateData.create(affiliate.copy()));
	}

	@Override
	public FindAllResponse findAll() {
		return new FindAllResponse(affiliateData.findAll());
	}

	@Override
	public FindByCodeResponse findByCode(String affiliateCode) {
		return new FindByCodeResponse(affiliateData.findByCode(affiliateCode));
	}

	@Override
	public UpdateResponse update(UpdateRequest affiliate) throws CloneNotSupportedException {
		return new UpdateResponse(affiliateData.update(affiliate.copy()));
	}

	@Override
	public DeleteByCodeResponse deleteByCode(String affiliateCode) {
		return new DeleteByCodeResponse(affiliateData.deleteByCode(affiliateCode));
	}

	@Override
	public WithdrawalOfFundResponse requestForWithdrawalOfFund(WithdrawalOfFundRequest request) {
		return affiliateData.requestForWithdrawalOfFund(request);
	}	
	
//	@PostMapping(path = "/requestForWithdrawalOfFund", consumes = "application/json", produces = "application/json")
//	public WithdrawalOfFundResponse requestForWithdrawalOfFund(@RequestBody WithdrawalOfFundRequest request) {		
//		return affiliateData.requestForWithdrawalOfFund(request);		
//	}
//	
//	@PostMapping(path = "/linkPersonToAFPInsuranceResponse", consumes = "application/json", produces = "application/json")
//	public LinkPersonToAFPInsuranceResponse LinkPerson(@RequestBody LinkPersonToAFPInsuranceRequest person) {
//		LinkPersonToAFPInsuranceResponse response = new LinkPersonToAFPInsuranceResponse();					
//		return response;
//	}

	
	
}
