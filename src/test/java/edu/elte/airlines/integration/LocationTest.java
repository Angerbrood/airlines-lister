package edu.elte.airlines.integration;

import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.LocationDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.LocationService;
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
public class LocationTest extends AbstractIntegrationTest<Location, LocationDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(LocationTest.class);

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationDtoFactory locationDtoFactory;
    private LocationDto locationDto;


    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        locationDto = locationDtoFactory.createOneAndSave();
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Location, LocationDto, Integer> getService() {
        return locationService;
    }

    @Override
    protected AbstractDtoFactory<Location, LocationDto, Integer> getFactory() {
        return locationDtoFactory;
    }

    @Override
    protected LocationDto getDto() {
        return locationDto;
    }
}
