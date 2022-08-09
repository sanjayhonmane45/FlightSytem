package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	
	@Query(value="Select * from Airport",nativeQuery=true)
	public List<Airport> viewAirport();

	@Query(" select a from Airport a WHERE a.airportCode=:aCd ")
	public Airport getAirportByCode(int aCd);


}
