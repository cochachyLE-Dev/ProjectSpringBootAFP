package pe.com.bootcamp.testing.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import pe.com.bootcamp.controllers.AuthenticationController;

@WebMvcTest(controllers = AuthenticationController.class)
public class AuthenticationControllerTest2 {	
		
	@Autowired
    private MockMvc mvc;
	
	@Test
	@WithMockUser(username = "lcochachi-user", password = "password", authorities = { "USER" })
	public void test() throws Exception {
		mvc.perform(get("http://localhost:8084/refreshtoken").accept("application/json")
				.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsY29jaGFjaGktdXNlciIsImlzVXNlciI6dHJ1ZSwiZXhwIjoxNjU5OTcxMjI4LCJpYXQiOjE2NTk5Njk0Mjh9.vSqguERjffp8PJsYmhDdwbo9ZYhsd5gK9JhpWnyG8KUnKaIK1OovSKKjqoaTH8iTt2ibA4l998ka9kjydTIT4A")
                .with(csrf()))
        .andExpect(status().isOk());		
	}

}
