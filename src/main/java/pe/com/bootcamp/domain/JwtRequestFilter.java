package pe.com.bootcamp.domain;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtToken jwtToken;
		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestTokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
				
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			
			jwtToken = requestTokenHeader.substring(7);					
			username = this.jwtToken.getUsernameFromToken(jwtToken);
						
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) 
			{						
				if(StringUtils.hasText(jwtToken) && this.jwtToken.validateToken(jwtToken)) 
				{			
					logger.info("validateToken: pased");
					
					UserDetails userDetails = new User(this.jwtToken.getUsernameFromToken(jwtToken), "", this.jwtToken.getRolesFromToken(jwtToken));						
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());				
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));						
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}
				
		filterChain.doFilter(request, response);
	}		
}

