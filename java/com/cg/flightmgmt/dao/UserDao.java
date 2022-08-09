package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.UserRepository;
import com.cg.flightmgmt.service.UserService;

@Service
public class UserDao implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User addUser(User user)
	{
		  return repository.save(user);
		
	}

	@Override
	public List<User> viewUser() 
	{
		return repository.findAll();
		
	}
	
	@Override
	public User updateUser(User user) throws UserNotFoundException
	{
	String number=user.getMobileNumber();
	String uName=user.getUserName();
	String uType=user.getUserType();
	String uPassword=user.getPassword();
	String uEmail=user.getEmail();
	BigInteger uId=user.getUserId();
	if( repository.updateUser(number,uName,uType,uPassword,uEmail, uId)==1)
	{
	return repository.getById(user.getUserId());
	}
	else
	{
	throw new UserNotFoundException("This user is not been updated");
	}
	}

	@Override
	public User deleteUser(BigInteger userId) throws UserNotFoundException
	{
		if( repository.deleteUser(userId)==1)
		{
		return repository.getById(userId);
		}
		else {
		throw new UserNotFoundException("This user is not been removed");
		}
		 
	}

	@Override
	public User viewUser(BigInteger userId) throws UserNotFoundException {
		User user = repository.getByUserId(userId);
		return user;
	}
		
	@Override
	public User validateUser(User user) throws UserNotFoundException
	{
	BigInteger uid=user.getUserId();
	String userName=user.getUserName();
	String password=user.getPassword();
	if(userName.equals(repository.getUserName(uid)) && password.equals(repository.getUserPassword(uid)))





	{





	return repository.getById(user.getUserId());
	}
	else
	{
	throw new UserNotFoundException("User not found");
	}





	}

	
}