package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
/*
 * With the help of @Entity annotation we are making this class as an entity
 * and mapping it to a database table
 * Providing the table name with the help of @Table(name="")
*/
@Table(name="Passenger_table")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passenger {
	/* specifies the primary key of an entity*/
	@Id
	@Column(name="PNR_number")
	private BigInteger pnrNumber;
	@NotNull(message="Passenger name should not be null")
	/*@NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, and its size/length is greater than zero*/
	@NotEmpty(message="Passenger name should not be empty")
	@Column(name="passengerName")
	private String passengerName;
	@NotNull(message="Passenger age should not be null")
	@Column(name="passengerAge")
	private int passengerAge;
	@NotNull(message="Passenger UIN should not be null")
	@Digits(integer=12, fraction=0)
	@Column(name="passengerUIN")
	private BigInteger passengerUIN;
	@Column(name="luggage")
	private Double luggage;
	/*@ManyToOne
	@JoinColumn(name="bookingId")
	@JsonIgnore
	private Booking booking;*/
	/*passenger constructor*/
	public Passenger(BigInteger pnrNumber2, String string, int i, BigInteger passengerUIN2, double d) {
		
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
		}
	
	/* Adding getters and setters for retrieving and updating the values. */
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
	/*public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;}*/
	
}
