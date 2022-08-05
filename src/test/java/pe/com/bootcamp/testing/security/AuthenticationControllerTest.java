package pe.com.bootcamp.testing.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pe.com.bootcamp.controllers.AuthenticationController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AuthenticationController.class)
public class AuthenticationControllerTest {	
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Before
    public void setup() {
      mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	@Test
	@WithMockUser(username = "lcochachi-user", authorities = { "ADMIN", "USER" })
	public void test() throws Exception {
		mockMvc.perform(get("/refreshtoken")				
				.accept("application/json"))
		.andExpect(status().isOk());
	}

}
