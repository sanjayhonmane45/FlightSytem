package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, BigInteger>{

	@Transactional
	@Modifying
	@Query("delete  from ScheduledFlight f where f.scheduleFlightId=:fId")
	Integer deleteFlightSchedule(BigInteger fId);
	
	
	@Transactional
	@Modifying
	@Query("update ScheduledFlight SET flight=:flt,availableSeats=:avSeat,schedule=:sched WHERE scheduleFlightId=:schId")
	Integer modifyScheduleFlight(BigInteger schId,Flight flt,int avSeat,Schedule sched);
}
