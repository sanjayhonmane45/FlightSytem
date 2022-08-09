package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Booking_table")
/* @JsonIgnoreProperties

annotation is used at the class level to ignore fields during serialization and deserialization. 
The properties that are declared in this annotation will not be mapped to the JSON content.*/
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
	@Id
	
	@Column(name="bookingId")
	private BigInteger bookingId;
	
	/*
	 * JPA allows you to define Many-to-one relationships between entity classes
	 * using the @ManyToOne annotation
	 */
	@ManyToOne
	@JoinColumn(name ="userId")
	/* @JsonIgnore is used to tell Jackson to ignore a certain property (field) of a Java object. 
	*The property is ignored both when reading JSON into Java objects,
	 *and when writing Java objects into JSON.
	*/
	@JsonIgnore
	private User userId;
	/*it's not null, but it can be empty*/
	@NotNull(message="Booking Date must not be null")
	@Column(name="bookingDate")
	private LocalDate bookingDate;
	
	/*
	 * JPA allows you to define One-to-Many relationships between entity classes
	 * using the @OneToMany annotation
	 */
	@OneToMany( cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private List<Passenger> passengerList = new ArrayList<>();
	
	@NotNull(message="Ticket cost must not be null")
	@Column(name="ticketCost")
	private double ticketCost;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleFlightId")
	@JsonIgnore
	private ScheduledFlight flight;
	
	@JsonIgnore
	private int noOfPassangers;
	
	

		public Booking(BigInteger bookingId, User userId,LocalDate bookingDate, List<Passenger> passengerList,double ticketCost,
				ScheduledFlight flight,
				int noOfPassangers) {
				super();
				this.bookingId = bookingId;
				this.userId = userId;
				this.bookingDate = bookingDate;
				this.passengerList = passengerList;
				this.ticketCost = ticketCost;
				this.flight = flight;
				this.noOfPassangers = noOfPassangers;
				}
		// TODO Auto-generated constructor stub
	
	public Booking() {
			super();
		}
	/*
	 * Adding getters and setters for retrieving and updating the values.
	 */

	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public ScheduledFlight getFlight() {
		return flight;
	}
	public void setFlight(ScheduledFlight flight) {
		this.flight = flight;
	}
	public int getNoOfPassangers() {
		return noOfPassangers;
	}
	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	public void addPassenger(Passenger passenger) {
	//	passenger.setBooking(this);
		this.getPassengerList().add(passenger);
	}
	public void deletePassenger(Passenger passenger) {
	//	passenger.setBooking(this);
		BigInteger pnrNumber = passenger.getPnrNumber();
		for(int i=0;i<this.getPassengerList().size();i++)
		{
			if((this.getPassengerList().get(i).getPnrNumber().compareTo(pnrNumber))==0) 
			{
				this.getPassengerList().remove(i);
			}
		}	
	}
}
