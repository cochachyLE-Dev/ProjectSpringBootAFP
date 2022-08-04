package pe.com.bootcamp.domain.entities.Affiliate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.com.bootcamp.utilities.ResultBase;

@AllArgsConstructor
public class CreateResponse extends ResultBase {
	@Getter @Setter
	private String link; 
	
	public CreateResponse(final ResultBase result) {
		super(result.isIbException(), result.getMessage());
	}
}
