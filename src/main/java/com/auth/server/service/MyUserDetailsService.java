package com.auth.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.server.model.MyUserDetails;
import com.auth.server.model.User;
import com.auth.server.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User usr = userRepository.findByUserName(username);
		if(usr==null)
			throw new UsernameNotFoundException("User Not Found" + username);
		return new MyUserDetails(usr);
	}

}
