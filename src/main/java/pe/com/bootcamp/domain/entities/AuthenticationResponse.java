package pe.com.bootcamp.domain.entities;

import lombok.Getter;

public class AuthenticationResponse {
	
	@Getter
	private String token;	
	
	public AuthenticationResponse() {
		token = null;
	}
	public AuthenticationResponse(String token) {
		this.token = token;
	}
}
