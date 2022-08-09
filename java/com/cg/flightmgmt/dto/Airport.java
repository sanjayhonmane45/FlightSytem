package com.cg.flightmgmt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Airport_table")
/* @JsonIgnoreProperties

annotation is used at the class level to ignore fields during serialization and deserialization. 
The properties that are declared in this annotation will not be mapped to the JSON content.*/
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airport {
	@Id
	@Column(name="airportCode")
	@NotNull(message = "Airport Code should not be Empty")
	private int airportCode;
	
	/*@Pattern Checks if the annotated string matches the regular expression*/
	/*It will take  a to z and A to Z */
	@Pattern(regexp="[a-zA-z ]*",message="Airport Name should have only alphabets")
	@NotNull(message="Airport Name should not be Empty")
	
	/*@Size annotation is used to restrict the filed length to a specified value. It has attributes such as max and min which *are used to set the maximum and minimum values respectively. The message attribute in this annotation is used to *display a default message on validation failure.
	*/
	@Size(min=3,message="Airport Name should have minimum 3 alphabets")
	@Column(name="airportName")
	private String airportName;
	
	@NotNull(message="Airport Location should not be Empty")
	@Size(min=3,message="Airport Location should have minimum 3 alphabets")
	@Column(name="airportLocation")
	private String airportLocation;
	
	/*Airport Constructor*/
	public Airport() {
		super();
	}
	public Airport(int airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	/*
	 * Adding getters and setters for retrieving and updating the values.
	 */
	
	public int getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(int airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
	@Override
	public String toString() {
		return "Airport <" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '>';
	}
}
