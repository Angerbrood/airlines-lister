package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class AirlineServiceTest extends AbstractServiceTest<Airline, AirlineDto> {

    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirlineDao airlineDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private AirlineFactory airlineFactory;

    @Override
    protected CrudService<Airline, AirlineDto, Integer> getService() {
        return airlineService;
    }

    @Override
    protected CrudDao<Airline, Integer> getDao() {
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

    @Override
    protected AirlineDto createDto() {
        return new AirlineDto();
    }
}
