package edu.elte.airlines.integration;

import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.PassengerFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.PassengerService;
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
public class PassengerTest extends AbstractIntegrationTest<Passenger, Integer> {
    private static Logger logger = LoggerFactory.getLogger(PassengerTest.class);

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PassengerFactory passengerFactory;
    private Passenger userPersonalDataDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        userPersonalDataDto = passengerFactory.createOne();
        userPersonalDataDto.setId(getService().create(userPersonalDataDto));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Integer, Passenger> getService() {
        return passengerService;
    }

    @Override
    protected AbstractFactory<Passenger> getFactory() {
        return passengerFactory;
    }

    @Override
    protected Passenger getEntity() {
        return userPersonalDataDto;
    }
}
