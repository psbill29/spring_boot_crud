package com.trinity.springbootcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trinity.springbootcrud.model.User;
import com.trinity.springbootcrud.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/get")
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User postUsers(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Transactional
	@DeleteMapping("/deleteByName/{name}")
	public void deleteByName(@PathVariable String name) {
		 userRepository.deleteByName(name);
	}
}
