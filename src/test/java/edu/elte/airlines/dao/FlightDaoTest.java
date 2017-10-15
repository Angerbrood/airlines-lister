package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.factory.domain.FlightFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
public class FlightDaoTest {

    @Autowired
    private FlightFactory flightFactory;
    @Autowired
    private FlightDao flightDao;

    private Flight flightToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", flightDao);
        flightToModifyOrDelete = flightFactory.createOne();
        flightDao.createEntity(flightToModifyOrDelete);
        assertNotNull("Id should not be null after save", flightToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        Flight flight = flightFactory.createOne();
        assertNull("Id should be null before save", flight.getId());
        flightDao.createEntity(flight);
        assertNotNull("Id should not be null after save", flight.getId());
    }
    @Test
    public void testFindById() {
        int id = flightToModifyOrDelete.getId();
        Flight airline = flightDao.findById(id);
        assertNotNull("Airline should not be null", airline);
    }
    @Test
    public void testUpdate() {
        flightToModifyOrDelete.setFlightNumber("1234");
        assertNotNull("Id should not be null before update", flightToModifyOrDelete.getId());
        flightDao.updateEntity(flightToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", flightToModifyOrDelete.getId());
        flightDao.deleteEntity(flightToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<Flight> result = flightDao.list();
        assertNotNull("List should not be null", result);
    }


}
