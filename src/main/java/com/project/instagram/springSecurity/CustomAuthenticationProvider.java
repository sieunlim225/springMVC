package com.project.instagram.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private SecurityService securityService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String)authentication.getPrincipal();		
		String password = (String)authentication.getCredentials();
		CustomUserDetail user = null;
		try {
			
			user = securityService.loadUserByUsername(username);
			//password
			
		}catch(BadCredentialsException e){
			throw e;
		}catch(LockedException e){
			throw e;
		}catch(UsernameNotFoundException e){
            throw e;  
		}catch(DisabledException e){
            throw e;
		}catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage());
		}
		//authorities 
		/*List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(securityUserDetails.getAuthentication()));
		securityUserDetails.setAuthorities(auth);*/
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
