package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.factory.domain.FlightFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.FlightService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
@WebAppConfiguration
public class FlightServiceTest extends AbstractServiceTest<Flight> {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private FlightFactory flightFactory;


    @Override
    protected CrudService<Integer, Flight> getService() {
        return flightService;
    }

    @Override
    protected CrudDao<Integer, Flight> getDao() {
        return flightDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Flight> getEntityClass() {
        return Flight.class;
    }

    @Override
    protected Flight createEntity(boolean withId) {
        Flight flight = flightFactory.createOne();
        if(withId) {
            flight.setId(1);
        }
        return flight;
    }

}
