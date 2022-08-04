package pe.com.bootcamp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @AllArgsConstructor @Getter @Setter
@Entity @Table
public class Affiliate {
	@Id	
	public String code;	
	@Column
	private String typeOfIdentityDocument;	
	@Column
	private String identificationNumber;	
	@Column
	public String origen;
	@Column
	public String typeCommission;
	@Column
	public String currentAFP;
	@Column
	public LocalDate dateOfLastContribution;
	@Column
	public LocalDate dateOfConsultation;
	@Column
	public LocalDate dateOfEntryToTheSPP;
	@Column
	public String typeOfWorker; // Dependent / Independent
	@Column
	public String status;
	@Column
	public LocalDate dateOfAffiliationToCurrentAFP;
	
	@OneToOne
	@JoinColumn(name = "code")
	public Contribution contribution;	

	public Affiliate() {}
	
	public Affiliate(String code, String typeOfIdentityDocument, String identificationNumber, String origen,
			String typeCommission, String currentAFP, LocalDate dateOfLastContribution, LocalDate dateOfConsultation,
			LocalDate dateOfEntryToTheSPP, String typeOfWorker, String status,
			LocalDate dateOfAffiliationToCurrentAFP) {
		this.code = code;
		this.typeOfIdentityDocument = typeOfIdentityDocument;
		this.identificationNumber = identificationNumber;
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
