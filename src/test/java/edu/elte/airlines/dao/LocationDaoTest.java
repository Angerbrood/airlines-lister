package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.factory.domain.LocationFactory;
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
public class LocationDaoTest {

    @Autowired
    private LocationFactory flightFactory;
    @Autowired
    private LocationDao locationDao;

    private Location locationToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", locationDao);
        locationToModifyOrDelete = flightFactory.createOne();
        locationDao.createEntity(locationToModifyOrDelete);
        assertNotNull("Id should not be null after save", locationToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        Location location = flightFactory.createOne();
        assertNull("Id should be null before save", location.getId());
        locationDao.createEntity(location);
        assertNotNull("Id should not be null after save", location.getId());
    }
    @Test
    public void testFindById() {
        int id = locationToModifyOrDelete.getId();
        Location location = locationDao.findById(id);
        assertNotNull("Airline should not be null", location);
    }
    @Test
    public void testUpdate() {
        locationToModifyOrDelete.setCountry("updated");
        assertNotNull("Id should not be null before update", locationToModifyOrDelete.getId());
        locationDao.updateEntity(locationToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", locationToModifyOrDelete.getId());
        locationDao.deleteEntity(locationToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<Location> result = locationDao.list();
        assertNotNull("List should not be null", result);
    }

}
