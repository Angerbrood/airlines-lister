package edu.elte.airlines.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "AIRLINE")
public class Airline implements EntityInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AIRLINE_ID")
	private Integer id;
	@Column(name = "ALIRLINE_NAME", nullable = false)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<Flight> flights;
	
	public Airline() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Collection<Flight> flights) {
		this.flights = flights;
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	public void removeAirline(int index) {
		if(index >= flights.size()) {
			throw new RuntimeException("Invalid index");
		} else {
			List<Flight> tempFights = (List<Flight>) flights;
			tempFights.remove(index);
		}
	}
	@Override
	public String toString() {
		return "Airline{" +
				"id=" + id +
				", name='" + name + '\'' +
				", flights=" + flights +
				'}';
	}
}
