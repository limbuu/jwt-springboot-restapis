package com.example.jwtspringbootrestapis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtspringbootrestapis.domain.ApplicationUser;
import com.example.jwtspringbootrestapis.repository.ApplicationUserRepository;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@PostMapping(value="/signup")
	public ApplicationUser signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return this.applicationUserRepository.save(user);
	}
	
	@GetMapping
	public List<ApplicationUser> getAllUsers() {
		return this.applicationUserRepository.findAll();
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable long id) {
		this.applicationUserRepository.delete(id);
		return "success";
	}
}
