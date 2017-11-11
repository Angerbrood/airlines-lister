package edu.elte.airlines.service.interfaces;

import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;

public interface FlightService extends CrudService<Flight, FlightDto, Integer> {

    void bookFlight(Integer userId, Integer flightId);
}
