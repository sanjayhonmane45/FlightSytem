package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.FlightRepository;
import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;
import com.cg.flightmgmt.service.ScheduledFlightService;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Proxy(lazy=false)
public class ScheduledFlightDao implements ScheduledFlightService{
	@Autowired
	private ScheduledFlightRepository repo;
	
	@Autowired
	private ScheduleRepository repo1;
	
	@Autowired
	private FlightRepository repo2;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight flight, BigInteger scheduleId, BigInteger flightNumber) {
		Schedule schedule = repo1.getById(scheduleId);
		Flight realFlight = repo2.getById(flightNumber);
		flight.setSchedule(schedule);
		flight.setFlight(realFlight);
		return repo.save(flight);
	}	
	@Override
	public List<ScheduledFlight> viewScheduledFlights(){
		return repo.findAll();
	}
	@Override
	public List<ScheduledFlight> viewScheduledFlight(BigInteger flightno){
		List<ScheduledFlight> ans = new ArrayList<>();
		List<ScheduledFlight> list = repo.findAll();
		for(ScheduledFlight s: list) {
			if(s.getFlight().getFlightNumber().compareTo(flightno)==0) {
				ans.add(s);
			}
		}
		return ans;
	}
	@Override
	public ScheduledFlight deleteFlightSchedule(BigInteger flightno) throws FlightNotFoundException{
		
		if( repo.deleteFlightSchedule(flightno)==1)
		{
			return repo.getById(flightno);
		}
		else {
			throw new FlightNotFoundException("No ScheduleFlight Found");
		}
	}
	@Override
	public ScheduledFlight modifyFlightSchedule(ScheduledFlight schFlight) throws FlightNotFoundException {
		
//		BigInteger scheduleFlightId=schFlight.getScheduleFlightId();
//		Flight flight=schFlight.getFlight();
//		int availableSeats=schFlight.getAvailableSeats();
//		Schedule schedule=schFlight.getSchedule();
//		 int k = repo.modifyScheduleFlight(scheduleFlightId, flight, availableSeats, schedule);
//		 if (k == 1)
//		 {
//			 return repo.getById(scheduleFlightId);
//		 }
//		 else
//		 {
//			 throw new FlightNotFoundException("ScheduledFlight not found");
//		 }
		ScheduledFlight sch=repo.getById(schFlight.getScheduleFlightId());

		schFlight.setFlight(sch.getFlight());
		schFlight.setSchedule(sch.getSchedule());




	return repo.save(schFlight);
		
	}
	
}