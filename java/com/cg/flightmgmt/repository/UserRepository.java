package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.User;

public interface UserRepository extends JpaRepository<User, BigInteger>{
	@Transactional
	@Modifying
	@Query("UPDATE User SET mobileNumber=:n1,userType=:uType,userName=:uName,password=:uPassword,email=:uEmail WHERE userId=:uId")
	Integer updateUser(String n1,String uType,String uName,String uPassword,String uEmail,BigInteger uId);
	
	@Transactional
	@Modifying
	@Query("delete  from User u where u.userId=:uId")
	Integer deleteUser(BigInteger uId);

	@Transactional
	@Modifying
	@Query(value = "select u from User u where u.userId=:userId")
	User getByUserId(BigInteger userId);
	
	@Query(value="select userName from User where userId=:uId")
	public String getUserName(BigInteger uId);



	@Query(value="select password from User where userId=:uId")
	public String getUserPassword(BigInteger uId);

	

}
