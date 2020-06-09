package com.example.demo.controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.beans.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.UserDaoService;

@RestController
public class UserResource {
	
	@Autowired
	UserDaoService userService;
	
	@GetMapping("/bean")
	public User userBean() {
		return new User(1,"Vikky1",new Date());
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveOneUser(@PathVariable int id) {
		
		User user = userService.findById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> model= new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		model.add(linkTo.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User newUser=userService.save(user);
		
		URI location=ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable int id) {
		User removedUser=userService.delete(id);
		if(removedUser==null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
}
