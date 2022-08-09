package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, BigInteger>{

	@Query(" select a from Booking a WHERE a.bookingId=:bId ")
	public Booking getBookingById(BigInteger bId);

	@Transactional
	@Modifying
	@Query("delete  from Booking b where b.bookingId=:bId")
	Integer deleteBook(BigInteger bId);
}
