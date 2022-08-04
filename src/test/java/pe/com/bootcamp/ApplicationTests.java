package pe.com.bootcamp;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.services.AFPClientService;
import pe.com.bootcamp.services.IAFPClientService;

@SpringBootTest
class ApplicationTests {

	@Test
	public void GetValideTokenAsync() {  
		
		IAFPClientService cliService = new AFPClientService();		
		AuthenticationResponse rsToken = cliService.Authorization("lcochachi-admin","password");		
	    assertFalse(rsToken.getToken().isEmpty());	    	   
	}	
}
