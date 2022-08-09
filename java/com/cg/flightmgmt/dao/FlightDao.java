package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.FlightRepository;
import com.cg.flightmgmt.service.FlightService;

@Service
public class FlightDao implements FlightService{
	@Autowired
	private FlightRepository repo;
	
	@Override
	public Flight addFlight(Flight flight) {
		return repo.save(flight);
	}
	
	@Override
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException{
		Flight flight = repo.getFlightById(flightno);
		if(flight!=null)
		{
			return flight;
		}
		else {
			throw new FlightNotFoundException("Flight not found");
		}
	}
	
	@Override
	public List<Flight> viewFlight(){
		return repo.findAll();
	}
	
	@Override
	public Flight deleteFlight(BigInteger flightno) throws FlightNotFoundException {

		if( repo.deleteFlight(flightno)==1)
		{
			return repo.getById(flightno);
		}
		else {
			throw new FlightNotFoundException("No Flight Found");
		}
	}
	
	@Override
	public Flight modifyFlight(Flight flight) throws FlightNotFoundException {
		 BigInteger flightNumber=flight.getFlightNumber();
		 String carrierName=flight.getCarrierName();
		 String flightModel=flight.getFlightModel();
		 int seatCapacity=flight.getSeatCapacity();
		 int k = repo.modifyFlight(flightNumber, carrierName, flightModel, seatCapacity);
		 if (k == 1)
		 {
			 return repo.getById(flightNumber);
		 }
		 else
		 {
			 throw new FlightNotFoundException("Flight not found");
		 }
				 
				 
	}
	
	
}
