package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface FlightService {
	public Flight addFlight(Flight flight);
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException;
	public List<Flight> viewFlight();
	public Flight deleteFlight(BigInteger flightno) throws FlightNotFoundException;
	public Flight modifyFlight(Flight flight) throws FlightNotFoundException;//(use return type as flight)
	
}
