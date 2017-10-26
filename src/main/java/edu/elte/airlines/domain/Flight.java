package edu.elte.airlines.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "flight")
public class Flight implements ModelInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AIRLINE_ID")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Airline airline;
	@Column(nullable = false)
	private String flightNumber;
	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Location start;
	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Location destination;
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false)
	private LocalDate landingDate;
	@Column(nullable = false)
	private Integer travelTime;
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<UserPersonalData> passengers;
	
	public Flight() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Location getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
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

	public Collection<UserPersonalData> getPassengers() {
		return Collections.unmodifiableCollection(passengers);
	}

	public void setPassengers(Collection<UserPersonalData> passengers) {
		this.passengers = passengers;
	}
}
