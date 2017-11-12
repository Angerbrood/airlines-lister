package edu.elte.airlines.integration;

import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.FlightFactory;
import edu.elte.airlines.factory.domain.UserFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class FlightTest extends AbstractIntegrationTest<Flight, Integer> {
    private static Logger logger = LoggerFactory.getLogger(FlightTest.class);

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightFactory flightFactory;
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private UserService userService;

    private Flight flight;
    private User loggedInUser;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        flight = flightFactory.createOne();
        flight.setId(getService().create(flight));
        loggedInUser = userFactory.createOne();
        userService.saveUser(loggedInUser);
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Integer, Flight> getService() {
        return flightService;
    }

    @Override
    protected AbstractFactory<Flight> getFactory() {
        return flightFactory;
    }

    @Override
    protected Flight getEntity() {
        return flight;
    }

    @Test
    public void testBookFlight() {
        FlightService flightService = (FlightService) getService();
        int oldPassengerSize = flight.getPassengers().size();
        flightService.bookFlight(loggedInUser.getId(), flight.getId());
        flight = getService().findById(flight.getId());
        assertFalse("Passengers list should not be empty", flight.getPassengers().isEmpty());
        assertTrue("One passenger should be on board", flight.getPassengers().size() != oldPassengerSize);

    }
    @Test
    public void testRemovePassenger() {
        FlightService flightService = (FlightService) getService();
        flightService.bookFlight(loggedInUser.getId(), flight.getId());
        int oldPassengerSize = flight.getPassengers().size();
        flight = getService().findById(flight.getId());
        assertFalse("Passengers list should not be empty", flight.getPassengers().isEmpty());
        flightService.removeReservation(loggedInUser.getId(), flight.getId());
        assertTrue("One passenger should be removed from the board", flight.getPassengers().size() != oldPassengerSize);
        assertFalse("user should not be on board", getService().findById(flight.getId()).getPassengers().contains(loggedInUser));
    }
    @Test
    public void testFindReservedFlights() {
        FlightService flightService = (FlightService) getService();
        List<Flight> result = flightService.getReservedFlightsByUser(loggedInUser.getId());
        assertNotNull("Reserved flights should not be null", result);
        //assertTrue("Reserved flights should not be empty", !result.isEmpty());

    }
}
