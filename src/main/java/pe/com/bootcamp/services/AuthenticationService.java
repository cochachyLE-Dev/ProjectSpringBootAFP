package pe.com.bootcamp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.bootcamp.constants.AuthorityType;

@Service
public class AuthenticationService implements UserDetailsService {

//	@Autowired
//	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		
		if("lcochachi-admin".equals(username)) {
			roles = Arrays.asList(new SimpleGrantedAuthority(AuthorityType.ADMIN));
			return new User("lcochachi-admin", "$2a$10$7XHA3w1L8xXQEzotbFMe8.EOh5ik2CppGjRanseUpSc0hgpK79cvK", roles);
		}else if("lcochachi-user".equals(username))
		{
			roles = Arrays.asList(new SimpleGrantedAuthority(AuthorityType.USER));
			return new User("lcochachi-user", "$2a$10$7XHA3w1L8xXQEzotbFMe8.EOh5ik2CppGjRanseUpSc0hgpK79cvK", roles);
		}
		else
		{
			throw new UsernameNotFoundException("User not found with username: "+ username);
		}
	}

//	public String encodePassword(String password) {
//		return bcryptEncoder.encode(password);
//	}
}
