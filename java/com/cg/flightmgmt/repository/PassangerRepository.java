package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Booking;

public interface PassangerRepository extends JpaRepository<Booking, BigInteger>{
	@Transactional
	@Modifying
	@Query("delete  from Passenger p where p.pnrNumber=:pId")
	Integer deletePassenger(BigInteger pId);

}
