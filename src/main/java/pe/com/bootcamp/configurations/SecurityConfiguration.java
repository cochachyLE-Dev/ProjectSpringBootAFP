package pe.com.bootcamp.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import pe.com.bootcamp.domain.JwtAuthEntryPoint;
import pe.com.bootcamp.domain.JwtRequestFilter;
import pe.com.bootcamp.services.AuthenticationService;

@SuppressWarnings("deprecation")
@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		
	@Autowired
	private JwtAuthEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private AuthenticationService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {	 	       
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests()
		.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
		.antMatchers("/authenticate","/refreshtoken","/register").permitAll()
        		
        .antMatchers("/person/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/person/create").hasRole("USER")
        		
        .antMatchers("/affiliate.*").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/affiliate/findByCode").hasRole("USER")        
        		
        .antMatchers("/contribution.*").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/contribution/findByAffiliateCode").hasRole("USER")
        
		.anyRequest().authenticated();		
		httpSecurity.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);                
	 }
}
