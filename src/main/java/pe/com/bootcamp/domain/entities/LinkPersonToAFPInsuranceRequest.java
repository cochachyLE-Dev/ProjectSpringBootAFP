package pe.com.bootcamp.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pe.com.bootcamp.entities.Person;

@Builder
public class LinkPersonToAFPInsuranceRequest {
	@Getter @Setter
	public Person person;
}
