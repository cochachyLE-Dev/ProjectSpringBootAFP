package pe.com.bootcamp.domain.entities;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationRequest {
	@Getter @Setter
	private String username;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String role;
		
	public AuthenticationRequest() {}	
	
	public AuthenticationRequest(String username, String password) {		
		this.username = username;
		this.password = password;
	}	
}
