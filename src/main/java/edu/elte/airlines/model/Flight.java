package edu.elte.airlines.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
@Table(name = "FLIGHT")
public class Flight implements EntityInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 1024)
	private String flightNumber;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	private Location start;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Location destination;
	@Column()
	private LocalDate startDate;
	@Column()
	private LocalDate landingDate;
	@Column()
	private Integer travelTime;
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<Passenger> passengers;
	
	public Flight() {
		
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

	public Collection<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}

	public void addPassenger(Passenger passenger) {
		if(!passengers.contains(passenger)) {
			passengers.add(passenger);
		} else {
			throw new RuntimeException("Passenger already on board");
		}
	}
	public void removePassenger(Passenger passenger) {
		int index = -1;
		List<Passenger> tempPassengers = (List<Passenger>) passengers;
		for(int i = 0; i < tempPassengers.size(); ++i) {
			Passenger currentPassenger = tempPassengers.get(i);
			if(currentPassenger.equals(passenger)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			throw new RuntimeException("Passenger is not on board");
		} else {
			tempPassengers.remove(index);
		}
	}
	@Override
	public String toString() {
		return "Flight{" +
				"id=" + id +
				", flightNumber='" + flightNumber + '\'' +
				", start=" + start +
				", destination=" + destination +
				", startDate=" + startDate +
				", landingDate=" + landingDate +
				", travelTime=" + travelTime +
				", passengers=" + passengers +
				'}';
	}
}
