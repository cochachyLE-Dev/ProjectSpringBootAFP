package pe.com.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.data.AffiliateData;
import pe.com.bootcamp.data.PersonData;
import pe.com.bootcamp.domain.entities.LinkPersonToAFPInsuranceRequest;
import pe.com.bootcamp.domain.entities.LinkPersonToAFPInsuranceResponse;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundRequest;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundResponse;

@RestController
@RequestMapping(path = "/affiliate")
public class AffiliateController {	
	
	@Autowired
	public AffiliateData affiliateData;	
	
	@Autowired
	public PersonData personData;	
	
	@PostMapping(path = "/requestForWithdrawalOfFund", consumes = "application/json", produces = "application/json")
	public WithdrawalOfFundResponse requestForWithdrawalOfFund(@RequestBody WithdrawalOfFundRequest request) {		
		return affiliateData.requestForWithdrawalOfFund(request);		
	}
	
	@PostMapping(path = "/linkPersonToAFPInsuranceResponse", consumes = "application/json", produces = "application/json")
	public LinkPersonToAFPInsuranceResponse LinkPerson(@RequestBody LinkPersonToAFPInsuranceRequest person) {
		LinkPersonToAFPInsuranceResponse response = new LinkPersonToAFPInsuranceResponse();					
		return response;
	}
}
