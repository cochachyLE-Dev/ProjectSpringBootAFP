package pe.com.bootcamp.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
public class Affiliate {
		
	@Getter @Setter
	public String code;
	@Getter @Setter
	public String origen;
	@Getter @Setter
	public String typeCommission;
	@Getter @Setter
	public String currentAFP;
	@Getter @Setter
	public LocalDate dateOfLastContribution;
	@Getter @Setter
	public LocalDate dateOfConsultation;
	@Getter @Setter
	public LocalDate dateOfEntryToTheSPP;
	@Getter @Setter
	public String typeOfWorker; // Dependent / Independent
	@Getter @Setter
	public String status;
	@Getter @Setter
	public LocalDate dateOfAffiliationToCurrentAFP;
	@Getter @Setter
	public Contribution contribution;
	
	public Affiliate(String code, String origen, String typeCommission, String currentAFP,
			LocalDate dateOfLastContribution, LocalDate dateOfConsultation, LocalDate dateOfEntryToTheSPP,
			String typeOfWorker, String status, LocalDate dateOfAffiliationToCurrentAFP) {
		this.code = code;
		this.origen = origen;
		this.typeCommission = typeCommission;
		this.currentAFP = currentAFP;
		this.dateOfLastContribution = dateOfLastContribution;
		this.dateOfConsultation = dateOfConsultation;
		this.dateOfEntryToTheSPP = dateOfEntryToTheSPP;
		this.typeOfWorker = typeOfWorker;
		this.status = status;
		this.dateOfAffiliationToCurrentAFP = dateOfAffiliationToCurrentAFP;
	}

	@Override
	public String toString() {
		return "Affiliate ["
				+ "code=" + code + ", "
				+ "origen=" + origen + ", "
				+ "typeCommission=" + typeCommission + ", "
				+ "currentAFP=" + currentAFP + ", "
				+ "dateOfLastContribution=" + dateOfLastContribution + ", "
				+ "dateOfConsultation=" + dateOfConsultation + ", "
				+ "dateOfEntryToTheSPP=" + dateOfEntryToTheSPP + ", "
				+ "typeOfWorker=" + typeOfWorker + ", "
				+ "status=" + status + ", "
				+ "dateOfAffiliationToCurrentAFP=" + dateOfAffiliationToCurrentAFP
				+ "]";
	}


}
