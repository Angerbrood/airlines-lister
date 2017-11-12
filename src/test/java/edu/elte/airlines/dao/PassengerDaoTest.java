package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.factory.domain.PassengerFactory;
import edu.elte.airlines.model.Passenger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
@WebAppConfiguration
public class PassengerDaoTest {
    @Autowired
    private PassengerFactory passengerFactory;
    @Autowired
    private PassengerDao passengerDao;

    private Passenger passengerToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", passengerDao);
        passengerToModifyOrDelete = passengerFactory.createOne();
        passengerDao.persist(passengerToModifyOrDelete);
        assertNotNull("Id should not be null after save", passengerToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        Passenger userPersonalData = passengerFactory.createOne();
        assertNull("Id should be null before save", userPersonalData.getId());
        passengerDao.persist(userPersonalData);
        assertNotNull("Id should not be null after save", userPersonalData.getId());
    }
    @Test
    public void testFindById() {
        int id = passengerToModifyOrDelete.getId();
        Passenger userPersonalData = passengerDao.findById(id);
        assertNotNull("Airline should not be null", userPersonalData);
    }
    @Test
    public void testUpdate() {
        passengerToModifyOrDelete.setAddress("updated");
        assertNotNull("Id should not be null before update", passengerToModifyOrDelete.getId());
        passengerDao.update(passengerToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", passengerToModifyOrDelete.getId());
        passengerDao.delete(passengerToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<Passenger> result = passengerDao.list();
        assertNotNull("List should not be null", result);
    }

}
