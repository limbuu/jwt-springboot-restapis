package com.example.jwtspringbootrestapis.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtspringbootrestapis.domain.ApplicationUser;
import com.example.jwtspringbootrestapis.repository.ApplicationUserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser user = this.applicationUserRepository.findByUsername(username);		
		
		if(user!=null) {
			return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Cannot find the user with given username :"+username);
		}
		
	}

}
