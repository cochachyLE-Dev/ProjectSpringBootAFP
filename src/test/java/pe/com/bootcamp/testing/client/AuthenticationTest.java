package pe.com.bootcamp.testing.client;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pe.com.bootcamp.domain.entities.AuthenticationRequest;
import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.testing.client.services.DemoClientService;
import pe.com.bootcamp.testing.client.services.IDemoClientService;

@SpringBootTest
class AuthenticationTest {

	@Test
	public void valideToken() {  
		
		IDemoClientService cliService = new DemoClientService();		
		
		AuthenticationResponse rsToken = 
				cliService.Authorization(AuthenticationRequest.builder()
						.username("lcochachi-admin")
						.password("password")
						.role("ROLE_ADMIN")
						.build());		
		
	    assertFalse(rsToken.getToken().isEmpty());	    	   
	}	
}
