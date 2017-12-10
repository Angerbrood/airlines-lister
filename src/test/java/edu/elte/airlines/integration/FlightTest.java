package edu.elte.airlines.integration;

import edu.elte.airlines.dto.SearchLocationDto;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.FlightFactory;
import edu.elte.airlines.factory.domain.LocationFactory;
import edu.elte.airlines.factory.domain.UserFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.Location;
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
    @Autowired
    private LocationFactory locationFactory;

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
    public void userHasEnoughMoneyToBookFlight() {
        FlightService flightService = (FlightService) getService();
        int oldPassengerSize = flight.getPassengers().size();
        flightService.bookFlight(loggedInUser.getSsoId(), flight.getId());
        flight = getService().findById(flight.getId());
        assertFalse("Passengers list should not be empty", flight.getPassengers().isEmpty());
        assertTrue("One passenger should be on board", flight.getPassengers().size() != oldPassengerSize);

    }
    @Test(expected = RuntimeException.class)
    public void poorUserBookFlightFails() {
        FlightService flightService = (FlightService) getService();
        loggedInUser.getUserPassengerData().setBalance(1);
        userService.updateUser(loggedInUser);
        flightService.bookFlight(loggedInUser.getSsoId(), flight.getId());

    }
    @Test(expected = RuntimeException.class)
    public void addOnePassengerMoreThanOnceFails() {
        FlightService flightService = (FlightService) getService();
        flightService.bookFlight(loggedInUser.getSsoId(), flight.getId());
        flightService.bookFlight(loggedInUser.getSsoId(), flight.getId());
    }
    @Test
    public void passengerRemovalSuccess() {
        FlightService flightService = (FlightService) getService();
        flightService.bookFlight(loggedInUser.getSsoId(), flight.getId());
        int oldPassengerSize = flight.getPassengers().size();
        flight = getService().findById(flight.getId());
        assertFalse("Passengers list should not be empty", flight.getPassengers().isEmpty());
        flightService.removeReservation(loggedInUser.getSsoId(), flight.getId());
        assertTrue("One passenger should be removed from the board", flight.getPassengers().size() != oldPassengerSize);
        assertFalse("user should not be on board", getService().findById(flight.getId()).getPassengers().contains(loggedInUser));
    }
    @Test
    public void findFlightsByUserSuccess() {
        FlightService flightService = (FlightService) getService();
        List<Flight> result = flightService.getReservedFlightsByUser(loggedInUser.getSsoId());
        assertNotNull("Reserved flights should not be null", result);

    }
    @Test
    public void findFlightsByLocationsSuccess() {
        //GIVEN
        FlightService flightService = (FlightService) getService();
        Location startLocation = locationFactory.createOne();
        Location endLocation = locationFactory.createOne();
        SearchLocationDto searchLocationDto =  new SearchLocationDto();
        searchLocationDto.setFromCity(startLocation.getName());
        searchLocationDto.setToCity(endLocation.getName());
        Flight flight = flightFactory.createOne();
        flight.setStart(startLocation);
        flight.setDestination(endLocation);
        flightService.create(flight);
        //WHEN
        List<Flight> result = flightService.findBySearchLocation(searchLocationDto);
        //THEN
        assertNotNull("Flight list should not be null", result);
        assertFalse("Flight list should not be empty", result.isEmpty());
    }
    @Test(expected = RuntimeException.class)
    public void findFLightsByLocationNullInputFails() {
        FlightService flightService = (FlightService) getService();
        flightService.findBySearchLocation(null);
    }
    @Test
    public void findFLightsByLocationInvalidInputFails() {
        FlightService flightService = (FlightService) getService();
        SearchLocationDto searchLocationDto =  new SearchLocationDto();
        searchLocationDto.setToCity("asd");
        searchLocationDto.setFromCity("fgf");
        List<Flight> result = flightService.findBySearchLocation(searchLocationDto);
        assertNotNull("Flight list should not be null", result);
        assertTrue("Flight list should be empty", result.isEmpty());
    }
}
