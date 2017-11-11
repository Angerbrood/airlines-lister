package edu.elte.airlines.integration;

import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.FlightDtoFactory;
import edu.elte.airlines.factory.dto.UserIdDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.UserIdService;
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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class FlightTest extends AbstractIntegrationTest<Flight, FlightDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(FlightTest.class);

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightDtoFactory flightDtoFactory;
    @Autowired
    private UserIdDtoFactory userIdDtoFactory;
    @Autowired
    private UserIdService userIdService;

    private FlightDto flightDto;
    private UserIdDto loggedInUser;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        flightDto = flightDtoFactory.createOne();
        flightDto.setId(getService().create(flightDto));
        loggedInUser = userIdDtoFactory.createOne();
        loggedInUser.setId(userIdService.create(loggedInUser));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Flight, FlightDto, Integer> getService() {
        return flightService;
    }

    @Override
    protected AbstractDtoFactory<Flight, FlightDto, Integer> getFactory() {
        return flightDtoFactory;
    }

    @Override
    protected FlightDto getDto() {
        return flightDto;
    }

    @Test
    public void testBookFlight() {
        FlightService flightService = (FlightService) getService();
        int oldPassengerSize = flightDto.getPassengers().size();
        flightService.bookFlight(loggedInUser.getId(), flightDto.getId());
        flightDto = getService().findById(flightDto.getId());
        assertFalse("Passengers list should not be empty", flightDto.getPassengers().isEmpty());
        assertTrue("One passenger should be on board", flightDto.getPassengers().size() != oldPassengerSize);

    }
}
