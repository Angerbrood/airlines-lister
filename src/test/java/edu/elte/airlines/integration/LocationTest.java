package edu.elte.airlines.integration;


import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.LocationFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.Location;
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
public class LocationTest extends AbstractIntegrationTest<Location, Integer> {
    private static Logger logger = LoggerFactory.getLogger(LocationTest.class);

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationFactory locationFactory;
    private Location locationDto;


    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        locationDto = locationFactory.createOne();
        locationDto.setId(getService().create(locationDto));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Integer, Location> getService() {
        return locationService;
    }

    @Override
    protected AbstractFactory<Location> getFactory() {
        return locationFactory;
    }

    @Override
    protected Location getEntity() {
        return locationDto;
    }
}
