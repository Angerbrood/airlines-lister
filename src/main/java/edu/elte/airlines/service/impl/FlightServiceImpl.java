package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.interfaces.FlightService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class FlightServiceImpl extends CrudServiceImpl<Integer, Flight> implements FlightService {
    private final AirlineDao airlineDao;
    private final FlightDao flightDao;
    private final UserDao userDao;
    public FlightServiceImpl(FlightDao dao, UserDao userDao, AirlineDao airlineDao) {
        super(dao);
        flightDao = dao;
        this.userDao = userDao;
        this.airlineDao = airlineDao;
    }

    @Override
    public void bookFlight(String ssoId, Integer flightId) {
        User user = userDao.findBySSO(ssoId);
        Flight flight = flightDao.findById(flightId);
        flight.addPassenger(user.getUserPassengerData());
        flightDao.update(flight);
    }

    @Override
    public void removeReservation(String ssoId, Integer flightId) {
        User user = userDao.findBySSO(ssoId);
        Flight flight = flightDao.findById(flightId);
        flight.removePassenger(user.getUserPassengerData());
        flightDao.update(flight);
    }

    @Override
    public List<Flight> getReservedFlightsByUser(String ssoId) {
        User user = userDao.findBySSO(ssoId);
        List<Flight> flights = flightDao.list();
        List<Flight> result = new LinkedList<>();
        for(Flight currentFlight : flights) {
            for(Passenger currentPassenger : currentFlight.getPassengers()) {
                if(currentPassenger.equals(user.getUserPassengerData())) {
                    result.add(currentFlight);
                }
            }
        }
        return result;
    }

    @Override
    public void createFlight(Flight flight, String airlineId) {
        flightDao.persist(flight);
        String temp = airlineId.split(" ")[1];
        Airline airline = airlineDao.findById(Integer.parseInt(temp));
        airline.addFlight(flight);
        airlineDao.update(airline);
    }
}
