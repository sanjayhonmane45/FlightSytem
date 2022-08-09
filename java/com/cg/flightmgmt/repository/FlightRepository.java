package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Flight;

public interface FlightRepository extends JpaRepository<Flight,BigInteger>{
	
	@Transactional
	@Modifying
	@Query("delete  from Flight f where f.flightNumber=:fId")
	Integer deleteFlight(BigInteger fId);

	@Transactional
	@Modifying
	@Query("update Flight SET carrierName=:carrierN,flightModel=:flightM,seatCapacity=:seatCap WHERE flightNumber=:fId ")
	Integer modifyFlight(BigInteger fId,String carrierN,String flightM,int seatCap);

	
	@Query(" select f from Flight f WHERE f.flightNumber=:fId ")
	public Flight getFlightById(BigInteger fId);
}
