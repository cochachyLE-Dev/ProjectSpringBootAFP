package pe.com.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bootcamp.controllers.interfaces.IContributionController;
import pe.com.bootcamp.data.ContributionData;
import pe.com.bootcamp.domain.entities.Contribution.CreateRequest;
import pe.com.bootcamp.domain.entities.Contribution.CreateResponse;
import pe.com.bootcamp.domain.entities.Contribution.DeleteByAffiliateCodeResponse;
import pe.com.bootcamp.domain.entities.Contribution.FindAllResponse;
import pe.com.bootcamp.domain.entities.Contribution.FindByAffiliateCodeResponse;
import pe.com.bootcamp.domain.entities.Contribution.UpdateRequest;
import pe.com.bootcamp.domain.entities.Contribution.UpdateResponse;

@RestController
@RequestMapping(path = "/contribution")
public class ContributionController implements IContributionController {

	@Autowired
	public ContributionData contributionData;	
	
	@Override
	public CreateResponse create(CreateRequest contribution) throws CloneNotSupportedException{
		return new CreateResponse(contributionData.create(contribution.copy()));
	}

	@Override
	public FindAllResponse findAll() {
		return new FindAllResponse(contributionData.findAll());
	}

	@Override
	public FindByAffiliateCodeResponse findByAffiliateCode(String affiliateCode) {
		return new FindByAffiliateCodeResponse(contributionData.findByAffiliateCode(affiliateCode));
	}

	@Override
	public UpdateResponse update(UpdateRequest contribution) throws CloneNotSupportedException {
		return new UpdateResponse(contributionData.update(contribution.copy()));
	}

	@Override
	public DeleteByAffiliateCodeResponse deleteByAffiliateCode(String affiliateCode) {
		return new DeleteByAffiliateCodeResponse(contributionData.deleteByAffiliateCode(affiliateCode));
	}
}
