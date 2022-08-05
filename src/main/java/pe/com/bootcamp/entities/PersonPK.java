package pe.com.bootcamp.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class PersonPK implements Serializable {		
	private static final long serialVersionUID = 1L;
	
	@Column(name = "type_of_identity_document", nullable = false)
	private String typeOfIdentityDocument;	
	@Column(name = "identification_number", nullable = false)
	private String identificationNumber;
	
	public PersonPK() {}
	public PersonPK(String typeOfIdentityDocument, String identificationNumber) {
		this.typeOfIdentityDocument = typeOfIdentityDocument;
		this.identificationNumber = identificationNumber;
	}		
	
	@Override
	public boolean equals(Object o) {

        if(o == null)
            return false;

        if(!(o instanceof PersonPK))
            return false;

        PersonPK id = (PersonPK) o;
        if(!(this.typeOfIdentityDocument.equals(id.getTypeOfIdentityDocument())))
            return false;

        if(!(this.identificationNumber.equals(id.getIdentificationNumber())))
            return false;

        return true;
    }

	@Override
    public int hashCode() {
        return Objects.hash(this.getTypeOfIdentityDocument(), this.getIdentificationNumber());
    }
}
