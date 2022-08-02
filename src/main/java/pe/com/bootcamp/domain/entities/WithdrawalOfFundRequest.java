package pe.com.bootcamp.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class WithdrawalOfFundRequest {
	@Getter @Setter
	public String typeOfIdentityDocument;
	@Getter @Setter
	public String identificationNumber;		
	@Getter @Setter
	public Double amount;
	@Getter @Setter
	public String typeOfAFP;
}
