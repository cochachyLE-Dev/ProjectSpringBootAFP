package pe.com.bootcamp.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import pe.com.bootcamp.constants.AuthorityType;
import pe.com.bootcamp.domain.JwtToken;
import pe.com.bootcamp.domain.entities.AuthenticationRequest;
import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.services.AuthenticationService;

@RestController
@CrossOrigin
public class AuthenticationController {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtToken jwtToken;
	
	@Autowired
	private AuthenticationService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String token = jwtToken.generateToken(userDetails);
		
		return  ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS",e);
		}
	}		
	
	@Secured({AuthorityType.USER, AuthorityType.ADMIN})
	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshtoken(@RequestHeader("Authorization") String authorization) throws Exception {
		String requestTokenHeader = authorization;			
				
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
		{
			logger.info("requestTokenHeader: true");
			String jwtTokenOld = requestTokenHeader.substring(7);									
			Claims claims = jwtToken.getAllClaimsFromToken(jwtTokenOld);		
			
			Map<String, Object> expectedMap = jwtToken.getMapFromIoJsonwebtokenClaims(claims);
			String token = jwtToken.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
			return ResponseEntity.ok(new AuthenticationResponse(token));
		} 
		else 
		{
			throw new Exception("INVALID_TOKEN");
		}
	}	
}
