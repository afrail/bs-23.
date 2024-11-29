package com.test.bs_23.auth.service;

import com.test.bs_23.auth.repository.UsersRepo;
import com.test.bs_23.auth.utill.CustomUserDetails;
import com.test.bs_23.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	UsersRepo userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		
		if(!user.getActive()) {
			throw new UsernameNotFoundException("User is not active with username: " + username);
		}
		
		if(user.getAccountExpired()) {
			throw new UsernameNotFoundException("User is expired with username: " + username);
		}
		
		if(user.getAccountLocked()) {
			throw new UsernameNotFoundException("User is locked with username: " + username);
		}
		
		if(user.getCredentialsExpired()) {
			throw new UsernameNotFoundException("User credentials expired with username: " + username);
		}

		return CustomUserDetails.build(user);
	}
	
	
	
	

}
