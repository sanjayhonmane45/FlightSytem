package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduleFlight(ScheduledFlight flight, BigInteger scheduleId,BigInteger flightNumber);
	public List<ScheduledFlight> viewScheduledFlights();
	public List<ScheduledFlight> viewScheduledFlight(BigInteger flightno);
	public ScheduledFlight deleteFlightSchedule(BigInteger flightno) throws FlightNotFoundException;
	public ScheduledFlight modifyFlightSchedule(ScheduledFlight flight) throws FlightNotFoundException;
}
