package pe.com.bootcamp.domain.entities.Affiliate;

import java.time.LocalDate;

import pe.com.bootcamp.entities.Affiliate;

public class UpdateRequest extends Affiliate {

	public UpdateRequest(String code, String typeOfIdentityDocument, String identificationNumber, String origen, String typeCommission, String currentAFP,
			LocalDate dateOfLastContribution, LocalDate dateOfConsultation, LocalDate dateOfEntryToTheSPP,
			String typeOfWorker, String status, LocalDate dateOfAffiliationToCurrentAFP) {
		super(code, typeOfIdentityDocument, identificationNumber, origen,
				typeCommission, currentAFP, dateOfLastContribution, dateOfConsultation,
				dateOfEntryToTheSPP, typeOfWorker, status,
				dateOfAffiliationToCurrentAFP);
	}
	
	public Affiliate copy() throws CloneNotSupportedException {
		return (Affiliate)super.clone();
	}
}
