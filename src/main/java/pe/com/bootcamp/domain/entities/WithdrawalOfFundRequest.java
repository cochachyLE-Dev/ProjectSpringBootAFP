package pe.com.bootcamp.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class WithdrawalOfFundRequest {
	@Getter @Setter
	private String typeOfIdentityDocument;
	@Getter @Setter
	private String identificationNumber;		
	@Getter @Setter
	private Double amount;
	@Getter @Setter
	private String typeOfAFP;
}
