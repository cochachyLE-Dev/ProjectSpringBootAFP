package pe.com.bootcamp.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
public class Person {
	
	@Getter @Setter
	public String typeOfIdentityDocument;
	@Getter @Setter
	public String identificationNumber;
	@Getter @Setter
	public String firstName;
	@Getter @Setter
	public String lastName;
	@Getter @Setter
	public LocalDate dateOfBirth;
	@Getter @Setter
	public String maritalStatus;
	@Getter @Setter
	public String ubigeo;
	@Getter @Setter
	public String nationatity;
	@Getter @Setter
	public String affiliateCode;
	@Getter @Setter
	public Affiliate affiliate;
	
	public Person(String typeOfIdentityDocument, String identificationNumber,String firstName, String lastName, LocalDate dateOfBirth, String maritalStatus, String ubigeo,
			String nationatity) {
		this.typeOfIdentityDocument = typeOfIdentityDocument;
		this.identificationNumber = identificationNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.ubigeo = ubigeo;
		this.nationatity = nationatity;
	}

	@Override
	public String toString() {
		return "Person ["
				+ "firstName=" + firstName +", "
				+ "lastName=" + lastName + ", "
				+ "dateOfBirth=" + dateOfBirth + ", "
				+ "maritalStatus=" + maritalStatus + ", "
				+ "ubigeo=" + ubigeo + ", "
				+ "nationatity=" + nationatity
				+ "]";
	}		
}
