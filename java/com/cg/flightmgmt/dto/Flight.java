package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
/*
 * With the help of @Entity annotation we are making this class as an entity
 * and mapping it to a database table
 * Providing the table name with the help of @Table(name="")
*/
@Table(name="Flight_table")
//@JsonIgnoreProperties ignore fields during serialisation and deserialisation
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
	 /* specifies the primary key of an entity*/
	@Id
	/*
	 * @Column annotation is used for Adding the column name in the table of a
	 * particular database
	 * 
	 * @NotNull-a constrained CharSequence, Collection, Map, or Array is valid as
	 * long as it's not null, but it can be empty*/
	@NotNull(message="Flight Number should not be null")
	@Column(name="flightnumber")
	private BigInteger flightNumber;
	
	@NotEmpty(message="Carrier Name should not be empty")
	@Column(name="carrierName")
	private String carrierName;
	
	@NotEmpty(message="Flight Model should not be empty")
	@Column(name="flightModel")
	private String flightModel;
	
	@NotNull(message="Seat Capacity should not be null")
	@Column(name="seatCapacity")
	private int seatCapacity;
	
	public Flight() {
		super();
	} 
	/*flight constructor*/
	public Flight(BigInteger flightNumber, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
	/*
	 * Adding getters and setters for retrieving and updating the values.
	 */
	public BigInteger getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
}
