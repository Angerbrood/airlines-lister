package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.factory.domain.AirlineFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
@WebAppConfiguration
public class AirlineDaoTest {
    @Autowired
    private AirlineDao airlineDao;
    @Autowired
    private AirlineFactory airlineFactory;

    private Airline airlineToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", airlineDao);
        airlineToModifyOrDelete = airlineFactory.createOne();
        airlineDao.persist(airlineToModifyOrDelete);
        assertNotNull("Id should not be null after save", airlineToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        Airline airline = airlineFactory.createOne();
        assertNull("Id should be null before save", airline.getId());
        airlineDao.persist(airline);
        assertNotNull("Id should not be null after save", airline.getId());
    }
    @Test
    public void testFindById() {
        int id = airlineToModifyOrDelete.getId();
        Airline airline = airlineDao.findById(id);
        assertNotNull("Airline should not be null", airline);
    }
    @Test
    public void testUpdate() {
        airlineToModifyOrDelete.setName(airlineToModifyOrDelete.getName() + "_updated");
        assertNotNull("Id should not be null before update", airlineToModifyOrDelete.getId());
        airlineDao.update(airlineToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", airlineToModifyOrDelete.getId());
        airlineDao.delete(airlineToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<Airline> result = airlineDao.list();
        assertNotNull("List should not be null", result);
    }
}
