package com.fahrul.springcassandra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springcassandra.model.User;
import com.fahrul.springcassandra.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(6491,"fahrul","Malang",33));
		users.add(new User(6492,"arka","Surabaya",3));
		users.add(new User(6493,"azriel","Malang",2));
		users.add(new User(6494,"Ika","Magetan",32));
		repository.saveAll(users);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age){
		return repository.findByAgeGreaterThan(age);
	}

}
