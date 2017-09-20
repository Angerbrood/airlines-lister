package edu.elte.airlines.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class AirlineDto implements DtoInterface<Integer> {
	private Integer id;
	private String name;
	private Collection<FlightDto> flights;

	public AirlineDto() {
		flights = new LinkedList<>();
	}
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Collection<FlightDto> getFlights() {
		return Collections.unmodifiableCollection(flights);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlights(Collection<FlightDto> flights) {
		this.flights = flights;
	}
	
	
}
