package edu.elte.airlines.service.interfaces;

import edu.elte.airlines.model.Flight;

import java.util.List;

public interface FlightService extends CrudService<Integer, Flight> {
    void bookFlight(Integer userId, Integer flightId);
    void removeReservation(Integer userId, Integer flightId);
    List<Flight> getReservedFlightsByUser(Integer userId);
}
