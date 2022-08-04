package pe.com.bootcamp.controllers.interfaces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.bootcamp.domain.entities.Contribution.UpdateRequest;
import pe.com.bootcamp.domain.entities.Contribution.CreateRequest;
import pe.com.bootcamp.domain.entities.Contribution.CreateResponse;
import pe.com.bootcamp.domain.entities.Contribution.DeleteByAffiliateCodeResponse;
import pe.com.bootcamp.domain.entities.Contribution.FindAllResponse;
import pe.com.bootcamp.domain.entities.Contribution.FindByAffiliateCodeResponse;
import pe.com.bootcamp.domain.entities.Contribution.UpdateResponse;

public interface IContributionController {

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public CreateResponse create(@RequestBody CreateRequest contribution) throws CloneNotSupportedException;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public FindAllResponse findAll();
	
	@GetMapping(path = "/findByAffiliateCode/{affiliateCode}", produces = "application/json")
	public FindByAffiliateCodeResponse findByAffiliateCode(@PathVariable String affiliateCode);
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public UpdateResponse update(@RequestBody UpdateRequest contribution) throws CloneNotSupportedException;
	
	@DeleteMapping(path = "/deleteByCode/{affiliateCode}", produces = "application/json")
	public DeleteByAffiliateCodeResponse deleteByAffiliateCode(@PathVariable String affiliateCode);
}
