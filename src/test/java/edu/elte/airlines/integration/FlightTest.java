package edu.elte.airlines.integration;

import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.FlightDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class FlightTest extends AbstractIntegrationTest<Flight, FlightDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(FlightTest.class);

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightDtoFactory flightDtoFactory;
    private FlightDto flightDto;


    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        flightDto = flightDtoFactory.createOneAndSave();
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
}
