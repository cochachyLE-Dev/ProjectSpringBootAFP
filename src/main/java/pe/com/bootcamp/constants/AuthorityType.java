package pe.com.bootcamp.constants;

import org.springframework.util.StringUtils;

public class AuthorityType {
	// Roles
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String USER = "ROLE_USER";	
	
	// Groups
	public static final String ALL = "#{AuthorityType.Authority()}";
	
	// Utilities
	public static String[] Authority() {		
		return new String[] { ADMIN, USER };
	}
	public static final String hasAnyAuthority(String... authorities) {
		String anyAuthorities = StringUtils.arrayToDelimitedString(authorities, "','");
		return "hasAnyAuthority('" + anyAuthorities + "')";
	}
}
