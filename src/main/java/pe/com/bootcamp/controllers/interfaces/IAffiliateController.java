package pe.com.bootcamp.controllers.interfaces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.bootcamp.domain.entities.WithdrawalOfFundRequest;
import pe.com.bootcamp.domain.entities.WithdrawalOfFundResponse;
import pe.com.bootcamp.domain.entities.Affiliate.CreateRequest;
import pe.com.bootcamp.domain.entities.Affiliate.CreateResponse;
import pe.com.bootcamp.domain.entities.Affiliate.DeleteByCodeResponse;
import pe.com.bootcamp.domain.entities.Affiliate.FindAllResponse;
import pe.com.bootcamp.domain.entities.Affiliate.FindByCodeResponse;
import pe.com.bootcamp.domain.entities.Affiliate.UpdateRequest;
import pe.com.bootcamp.domain.entities.Affiliate.UpdateResponse;

public interface IAffiliateController {
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public CreateResponse create(@RequestBody CreateRequest affiliate) throws CloneNotSupportedException;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public FindAllResponse findAll();
	
	@GetMapping(path = "/findByCode/{affiliateCode}", produces = "application/json")
	public FindByCodeResponse findByCode(@PathVariable String affiliateCode);
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public UpdateResponse update(@RequestBody UpdateRequest affiliate) throws CloneNotSupportedException;
	
	@DeleteMapping(path = "/deleteByCode/{affiliateCode}", produces = "application/json")
	public DeleteByCodeResponse deleteByCode(@PathVariable String affiliateCode);	
	
	@PostMapping(path = "/requestForWithdrawalOfFund", consumes = "application/json", produces = "application/json")
	public WithdrawalOfFundResponse requestForWithdrawalOfFund(@RequestBody WithdrawalOfFundRequest request);
}