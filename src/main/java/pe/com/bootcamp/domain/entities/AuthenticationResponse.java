package pe.com.bootcamp.domain.entities;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationResponse {
	
	@Getter @Setter
	private String token;	
	
	public AuthenticationResponse() {
		token = null;
	}
	public AuthenticationResponse(String token) {
		this.token = token;
	}
}
