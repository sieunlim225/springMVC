package com.project.instagram.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.instagram.dao.SecurityDao;

@Service
public class SecurityService implements UserDetailsService{

	@Autowired
	private SecurityDao securityDao;
	
	@Override
	public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CustomUserDetail user = securityDao.getUserById(username);
		if(user==null) {
			throw new UsernameNotFoundException("");
		}else {
			return user;
		}
	}

}
