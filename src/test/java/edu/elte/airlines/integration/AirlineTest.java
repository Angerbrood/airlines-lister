package edu.elte.airlines.integration;

import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.AirlineFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.CrudService;
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
public class AirlineTest extends AbstractIntegrationTest<Airline, Integer> {
    private static Logger logger = LoggerFactory.getLogger(AirlineTest.class);
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineFactory airlineFactory;
    private Airline airline;
    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        airline = airlineFactory.createOne();
        airline.setId(getService().create(airline));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Integer, Airline> getService() {
        return airlineService;
    }

    @Override
    protected AbstractFactory<Airline> getFactory() {
        return airlineFactory;
    }

    @Override
    protected Airline getEntity() {
        return airline;
    }

}
