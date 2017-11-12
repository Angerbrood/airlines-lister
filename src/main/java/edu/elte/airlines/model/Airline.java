package edu.elte.airlines.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AIRLINE")
public class Airline implements EntityInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AIRLINE_ID")
	private Integer id;
	@Column(name = "ALIRLINE_NAME", nullable = false)
	private String name;
	@OneToMany(fetch = FetchType.LAZY)
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
		return Collections.unmodifiableCollection(flights);
	}

	public void setFlights(Collection<Flight> flights) {
		this.flights = flights;
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
