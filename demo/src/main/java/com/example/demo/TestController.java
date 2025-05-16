package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/get")
	public String get() {
		return "Hi Rajesh ! Welcome to Our App";
	}
	
	@PostMapping("/add")
	public Iterable<User> addUser(@RequestBody User user) {
		userRepo.save(user);
		return userRepo.findAll();
	}
	@GetMapping("/getAll")
	public Iterable<User> getALl() {
		return userRepo.findAll();
	}
	@GetMapping("/getById")
	public Optional<User> getALl(@RequestParam int id) {
		return userRepo.findById(id);
	}
	
}
