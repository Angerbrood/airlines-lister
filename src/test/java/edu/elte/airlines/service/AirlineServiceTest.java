package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.factory.domain.AirlineFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.CrudService;
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
public class AirlineServiceTest extends AbstractServiceTest<Airline> {

    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineDao airlineDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private AirlineFactory airlineFactory;

    @Override
    protected CrudService<Integer, Airline> getService() {
        return airlineService;
    }

    @Override
    protected CrudDao<Integer, Airline> getDao() {
        return airlineDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Airline> getEntityClass() {
        return Airline.class;
    }

    @Override
    protected Airline createEntity(boolean withId) {
        Airline airline = airlineFactory.createOne();
        if(withId) {
            airline.setId(1);
        }
        return airline;
    }

}
