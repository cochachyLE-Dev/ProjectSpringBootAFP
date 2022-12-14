package pe.com.bootcamp.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import pe.com.bootcamp.constants.AuthorityIdentityType;
import pe.com.bootcamp.constants.AuthorityType;

@Component
public class JwtToken{	 	
		
	private String secret;
	private int jwtExpirationInMs;
	private int refreshExpirationDateInMs;
	
	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	@Value("${jwt.expirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) {
		this.jwtExpirationInMs = jwtExpirationInMs;
	}

	@Value("${jwt.refreshExpirationDateInMs}")
	public void setRefreshExpirationDateInMs(int refreshExpirationDateInMs) {
		this.refreshExpirationDateInMs = refreshExpirationDateInMs;
	}
	
	// Retrieve username from JWToken
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	// Retrieve expiration date from JWToken
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token); 
		return claimsResolver.apply(claims);
	}

	// For retrieving any information from token we will need the secret key 
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	// Check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}
	
	// Generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		
		if(roles.contains(new SimpleGrantedAuthority(AuthorityType.ADMIN)))
			claims.put(AuthorityIdentityType.ADMIN, true);
		if(roles.contains(new SimpleGrantedAuthority(AuthorityType.USER)))
			claims.put(AuthorityIdentityType.USER, true);		
		
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {				
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}
	
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);			
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {			
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		} catch (ExpiredJwtException ex) {			
			throw ex;
		}
	}
	// Validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
					
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}	
	public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
				
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();										
		List<SimpleGrantedAuthority> authorities = new LinkedList<>();
		
		claims.forEach((k,v) -> {						
			if(k == AuthorityIdentityType.ADMIN && Boolean.parseBoolean(v.toString()))
				authorities.add(new SimpleGrantedAuthority(AuthorityType.ADMIN));
			if(k == AuthorityIdentityType.USER && Boolean.parseBoolean(v.toString()))
				authorities.add(new SimpleGrantedAuthority(AuthorityType.USER));
		});		
				
		return authorities;
	}
	public Map<String, Object> getMapFromIoJsonwebtokenClaims(Claims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
}

