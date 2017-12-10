package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.factory.domain.PassengerFactory;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.PassengerService;
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
public class PassengerServiceTest extends AbstractServiceTest<Passenger> {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PassengerDao passengerDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private PassengerFactory passengerFactory;
    @Override
    protected CrudService<Integer, Passenger> getService() {
        return passengerService;
    }

    @Override
    protected CrudDao<Integer, Passenger> getDao() {
        return passengerDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Passenger> getEntityClass() {
        return Passenger.class;
    }

    @Override
    protected Passenger createEntity(boolean withId) {
        Passenger personalData = passengerFactory.createOne();
        if(withId) {
            personalData.setId(1);
        }
        return personalData;
    }
}
