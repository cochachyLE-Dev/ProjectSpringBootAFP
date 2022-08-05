package pe.com.bootcamp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
@Entity @Table(name = "Person")
@IdClass(PersonPK.class)
public class Person {					
		
	@Id
	//@Column(name = "type_of_identity_document", nullable = false)
	private String typeOfIdentityDocument;
	@Id
	//@Column(name = "identification_number", nullable = false)
	private String identificationNumber;	
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private LocalDate dateOfBirth;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "ubigeo")
	private String ubigeo;
	@Column(name = "nationatity")
	private String nationatity;			
	
	public Person() {}	
	
	public Person(String typeOfIdentityDocument, String identificationNumber, String firstName, String lastName,
			LocalDate dateOfBirth, String maritalStatus, String ubigeo, String nationatity) {
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
				+ "typeOfIdentityDocument=" + typeOfIdentityDocument +", "
				+ "identificationNumber=" + identificationNumber +", "
				+ "firstName=" + firstName +", "
				+ "lastName=" + lastName + ", "
				+ "dateOfBirth=" + dateOfBirth + ", "
				+ "maritalStatus=" + maritalStatus + ", "
				+ "ubigeo=" + ubigeo + ", "
				+ "nationatity=" + nationatity				
				+ "]";
	}	
}
