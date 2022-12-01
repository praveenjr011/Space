package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
	
	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	List<User> all() {
		return repository.findAll();
	}

	@PostMapping("/users")
	User newUser(@RequestBody User newEmployee) {
		return repository.save(newEmployee);
	}

	

	@GetMapping("/users/{username}")
	Optional<User> one(@PathVariable String username) {

		
		return repository.findByUsername(username);

	}


	@DeleteMapping("/users/{username}")
	void deleteUser(@PathVariable String username) {
		repository.deleteByUsername(username);
	}
}
