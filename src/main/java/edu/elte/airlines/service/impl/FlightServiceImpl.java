package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.interfaces.FlightService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class FlightServiceImpl extends CrudServiceImpl<Integer, Flight> implements FlightService {

    private final FlightDao flightDao;
    private final UserDao userDao;
    public FlightServiceImpl(FlightDao dao, UserDao userDao) {
        super(dao);
        flightDao = dao;
        this.userDao = userDao;
    }

    @Override
    public void bookFlight(Integer userId, Integer flightId) {
        User user = userDao.findById(userId);
        Flight flight = flightDao.findById(flightId);
        flight.addPassenger(user.getUserPassengerData());
        flightDao.update(flight);
    }

    @Override
    public void removeReservation(Integer userId, Integer flightId) {
        User user = userDao.findById(userId);
        Flight flight = flightDao.findById(flightId);
        flight.removePassenger(user.getUserPassengerData());
        flightDao.update(flight);
    }

    @Override
    public List<Flight> getReservedFlightsByUser(Integer userId) {
        User user = userDao.findById(userId);
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
}
