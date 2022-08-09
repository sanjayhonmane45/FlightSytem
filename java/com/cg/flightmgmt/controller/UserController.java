package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.UserDao;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController
{
	
	@Autowired
	private UserDao dao1;
	
	@PostMapping(path="/createUser")
	public User createUser(@Valid @RequestBody User user)
	{
		return dao1.addUser(user);
	}
	
	@GetMapping(path="/users")
	public List<User> viewAllUsers(){
		return dao1.viewUser();
	}
	
	@PutMapping(path="/updateUser")
	public User updateUser(@RequestBody User user) throws UserNotFoundException
	{
		
		return dao1.updateUser(user);
	}
	
	@DeleteMapping(path="/deleteUser/{userId}")
	public User removeUser(@PathVariable BigInteger userId ) throws UserNotFoundException
	{
		return dao1.deleteUser(userId);
	}
	
	@PutMapping(path="/validateUser")
	public User validateuser(@RequestBody User user) throws UserNotFoundException
	{
		return dao1.validateUser(user);
		
	}

}

