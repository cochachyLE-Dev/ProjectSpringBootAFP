package pe.com.bootcamp.utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ResultBase {	
	
	@Getter @Setter
	private boolean ibException;
	@Getter @Setter
	private String message;	
	
	public ResultBase() {}
	public ResultBase(boolean ibException, String message) {
		super();
		this.ibException = ibException;
		this.message = message;
	}	
}

