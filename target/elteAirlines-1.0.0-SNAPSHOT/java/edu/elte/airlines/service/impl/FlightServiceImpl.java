package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.dto.SearchLocationDto;
import edu.elte.airlines.model.*;
import edu.elte.airlines.service.interfaces.FlightService;

import java.util.*;


public class FlightServiceImpl extends CrudServiceImpl<Integer, Flight> implements FlightService {
    private final AirlineDao airlineDao;
    private final FlightDao flightDao;
    private final UserDao userDao;
    private final PassengerDao passengerDao;
    public FlightServiceImpl(FlightDao dao, UserDao userDao, AirlineDao airlineDao, PassengerDao passengerDao) {
        super(dao);
        flightDao = dao;
        this.userDao = userDao;
        this.airlineDao = airlineDao;
        this.passengerDao = passengerDao;
    }

    @Override
    public void bookFlight(String ssoId, Integer flightId) {
        User user = userDao.findBySSO(ssoId);
        Flight flight = flightDao.findById(flightId);
        long ticketPrice = flight.getTicketPrice();
        long userMoney = user.getUserPassengerData().getBalance();
        long newMoney = userMoney - ticketPrice;
        if(newMoney > 0) {
            user.getUserPassengerData().setBalance(newMoney);
            passengerDao.update(user.getUserPassengerData());
            flight.addPassenger(Passenger.copyPassenger(user.getUserPassengerData()));
            flightDao.update(flight);
        } else {
            throw new RuntimeException("User does not have enough money to buy a ticket");
        }


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
        Set<Flight> flights = new HashSet<>(flightDao.list());
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
        if(flight.getPassengers() == null) {
            flight.setPassengers(new LinkedList<>());
        }
        Location startLocation = flight.getStart();
        Location endLocation = flight.getDestination();
        if(startLocation.equals(endLocation)) {
            throw new RuntimeException("Start and destination cannot be the same place");
        }

        flightDao.persist(flight);
        Airline airline = airlineDao.findById(Integer.parseInt(airlineId));
        airline.addFlight(flight);
        airlineDao.update(airline);
    }

    @Override
    public void deleteFlight(Integer id) {
        Set<Airline> airlines = new HashSet<>( airlineDao.list());
        Flight flight = flightDao.findById(id);
        for(Airline currentAirline : airlines) {
            List<Flight> currentAirlineFlights = (List<Flight>) currentAirline.getFlights();
            for(int i = 0; i < currentAirlineFlights.size(); ++i) {
                if(id.equals(currentAirlineFlights.get(i).getId())) {
                    currentAirline.removeAirline(i);
                    airlineDao.update(currentAirline);
                    break;
                }
            }
        }
        flightDao.delete(flight);
    }

    @Override
    public List<Flight> findBySearchLocation(SearchLocationDto searchLocationDto) {
        Objects.requireNonNull(searchLocationDto);
        Set<Flight> flights = new HashSet<>(flightDao.list());
        List<Flight> result = new LinkedList<>();
        for(Flight currentFlight : flights) {
            String fromCityName = currentFlight.getStart().getName();
            String toCityName = currentFlight.getDestination().getName();
            if(fromCityName.equals(searchLocationDto.getFromCity()) && toCityName.equals(searchLocationDto.getToCity())) {
                result.add(currentFlight);
            }
        }
        return result;
    }
}
