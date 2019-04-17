package com.telusko.secureapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.telusko.secureapp.model.UserPrincipal;
import com.telusko.secureapp.model.Users;
import com.telusko.secureapp.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Users user = repo.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(user);
	}

}
