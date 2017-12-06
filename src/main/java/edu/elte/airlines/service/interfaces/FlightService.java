package edu.elte.airlines.service.interfaces;

import edu.elte.airlines.model.Flight;

import java.util.List;

public interface FlightService extends CrudService<Integer, Flight> {
    void bookFlight(String ssoId, Integer flightId);
    void removeReservation(String ssoId, Integer flightId);
    List<Flight> getReservedFlightsByUser(String ssoId);

    void createFlight(Flight flight, String airlineId);

    void deleteFlight(Integer id);
}
