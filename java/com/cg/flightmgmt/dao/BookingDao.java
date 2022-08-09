package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.BookingRepository;
import com.cg.flightmgmt.repository.PassangerRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;
import com.cg.flightmgmt.repository.UserRepository;
import com.cg.flightmgmt.service.BookingService;

@Service
public class BookingDao implements BookingService{
	
	/*@Autowired annotation is used for automatic dependency injection*/
	@Autowired
	private BookingRepository repo;
	@Autowired
	private UserRepository repo1;
	@Autowired
	private ScheduledFlightRepository repo2;
	@Autowired
	private PassangerRepository repo3;
	
	/*@Override annotation is used when we override a method in sub class*/
	@Override
	public void addBooking(Booking booking, BigInteger flightId,BigInteger userId) {
		
		ScheduledFlight currentflight = repo2.getById(flightId);
		booking.setFlight(currentflight);
		
		User user = repo1.getById(userId);
		booking.setUserId(user);
		
		int nPassengers = booking.getPassengerList().size();
		booking.setNoOfPassangers(nPassengers);
		
			int balence = booking.getFlight().getAvailableSeats() - booking.getNoOfPassangers();
			
			booking.getFlight().setAvailableSeats(balence);
			repo2.save(booking.getFlight());
			repo.save(booking);
		}
	
	
	@Override
	public List<Booking> viewBookings() {
		return repo.findAll();
	}

	@Override
	public void deleteBooking(BigInteger bookingId) throws BookingNotFoundException
	{
	
		Booking booking = repo.getBookingById(bookingId);
		
		repo.deleteBook(bookingId);
		
		for(Passenger passenger: booking.getPassengerList())
		{
			
			repo3.deletePassenger(passenger.getPnrNumber());
			}
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		Booking prevBooking = repo.getBookingById(booking.getBookingId());
		booking.setUserId(prevBooking.getUserId());
		booking.setFlight(prevBooking.getFlight());
		

		booking.setNoOfPassangers(booking.getPassengerList().size());
		return repo.save(booking);
	}

	@Override
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
		Booking booking = repo.getBookingById(bookingid);
		if(booking!=null)
		{
			return booking;
		}
		else {
			throw new BookingNotFoundException("Booking not found");
		}
	}

	@Override
	public boolean validateBooking(Booking booking) {
		boolean res = false;
		ScheduledFlight sf = booking.getFlight();
		int pass = booking.getNoOfPassangers();
		int seatsavailable = sf.getAvailableSeats();
		if (pass <= seatsavailable) {
			res = true;
		}
		return res;
	}

	
}
