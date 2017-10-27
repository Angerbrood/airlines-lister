package edu.elte.airlines.integration;

import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.AirlineDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.CrudService;
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

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class AirlineTest extends AbstractIntegrationTest<Airline, AirlineDto, Integer> {

    private static Logger logger = LoggerFactory.getLogger(AirlineTest.class);


    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineDtoFactory airlineDtoFactory;

    private AirlineDto airlineDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        airlineDto = airlineDtoFactory.createOne();
        airlineDto.setId(getService().create(airlineDto));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Airline, AirlineDto, Integer> getService() {
        return airlineService;
    }

    @Override
    protected AbstractDtoFactory<Airline, AirlineDto, Integer> getFactory() {
        return airlineDtoFactory;
    }

    @Override
    protected AirlineDto getDto() {
        return airlineDto;
    }
}
