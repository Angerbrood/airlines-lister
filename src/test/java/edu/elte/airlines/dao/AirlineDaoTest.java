package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.factory.domain.AirlineFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
public class AirlineDaoTest {
    @Autowired
    private AirlineDao airlineDao;
    @Autowired
    private AirlineFactory airlineFactory;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", airlineDao);
    }

    @Test
    public void testSave() {
        Airline airline = airlineFactory.createOne();
        assertNull("Id should be null before save", airline.getId());
        airlineDao.createEntity(airline);
        assertNotNull("Id should not be null after save", airline.getId());
    }
}
