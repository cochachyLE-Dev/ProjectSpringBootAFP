package pe.com.bootcamp.domain.entities;

import lombok.Getter;
import lombok.Setter;

public class ConsultContributionsRequest {
	@Getter @Setter
	private String affiliateCode;

	public ConsultContributionsRequest(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}
		
}
