package edu.elte.airlines.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class FlightDto implements DtoInterface<Integer> {
	private Integer id;
	private String flightNumber;
	private Integer airlineId;
	private LocationDto start;
	private LocationDto destination;
	private LocalDate startDate;
	private LocalDate landingDate;
	private Integer travelTime;
	private Collection<UserPersonalDataDto> passengers;
	
	public FlightDto() {
		passengers = new LinkedList<>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public LocationDto getStart() {
		return start;
	}

	public void setStart(LocationDto start) {
		this.start = start;
	}

	public LocationDto getDestination() {
		return destination;
	}

	public void setDestination(LocationDto destination) {
		this.destination = destination;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(LocalDate landingDate) {
		this.landingDate = landingDate;
	}

	public Integer getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Integer travelTime) {
		this.travelTime = travelTime;
	}

	public Collection<UserPersonalDataDto> getPassengers() {
		return Collections.unmodifiableCollection(passengers);
	}

	public void setPassengers(Collection<UserPersonalDataDto> passengers) {
		this.passengers = passengers;
	}
	
	
}
