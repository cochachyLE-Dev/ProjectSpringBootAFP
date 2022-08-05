package pe.com.bootcamp.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
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
	public AuthenticationRequest(String username, String password, String role) {		
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
