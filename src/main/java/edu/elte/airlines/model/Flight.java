package edu.elte.airlines.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

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
	@Column
	private long ticketPrice;
	@ManyToMany(fetch = FetchType.EAGER)
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Flight flight = (Flight) o;

		if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
		if (flightNumber != null ? !flightNumber.equals(flight.flightNumber) : flight.flightNumber != null)
			return false;
		if (start != null ? !start.equals(flight.start) : flight.start != null) return false;
		if (destination != null ? !destination.equals(flight.destination) : flight.destination != null) return false;
		if (startDate != null ? !startDate.equals(flight.startDate) : flight.startDate != null) return false;
		if (landingDate != null ? !landingDate.equals(flight.landingDate) : flight.landingDate != null) return false;
		if (travelTime != null ? !travelTime.equals(flight.travelTime) : flight.travelTime != null) return false;
		return passengers != null ? passengers.equals(flight.passengers) : flight.passengers == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
		result = 31 * result + (start != null ? start.hashCode() : 0);
		result = 31 * result + (destination != null ? destination.hashCode() : 0);
		result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
		result = 31 * result + (landingDate != null ? landingDate.hashCode() : 0);
		result = 31 * result + (travelTime != null ? travelTime.hashCode() : 0);
		result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
		return result;
	}

	public long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
