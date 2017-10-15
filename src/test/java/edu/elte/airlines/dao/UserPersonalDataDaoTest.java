package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.UserPersonalDataDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.factory.domain.UserPersonalDataFactory;
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
public class UserPersonalDataDaoTest {
    @Autowired
    private UserPersonalDataFactory userPersonalDataFactory;
    @Autowired
    private UserPersonalDataDao personalDataDao;

    private UserPersonalData locationToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", personalDataDao);
        locationToModifyOrDelete = userPersonalDataFactory.createOne();
        personalDataDao.createEntity(locationToModifyOrDelete);
        assertNotNull("Id should not be null after save", locationToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        UserPersonalData userPersonalData = userPersonalDataFactory.createOne();
        assertNull("Id should be null before save", userPersonalData.getId());
        personalDataDao.createEntity(userPersonalData);
        assertNotNull("Id should not be null after save", userPersonalData.getId());
    }
    @Test
    public void testFindById() {
        int id = locationToModifyOrDelete.getId();
        UserPersonalData userPersonalData = personalDataDao.findById(id);
        assertNotNull("Airline should not be null", userPersonalData);
    }
    @Test
    public void testUpdate() {
        locationToModifyOrDelete.setAddress("updated");
        assertNotNull("Id should not be null before update", locationToModifyOrDelete.getId());
        personalDataDao.updateEntity(locationToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", locationToModifyOrDelete.getId());
        personalDataDao.deleteEntity(locationToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<UserPersonalData> result = personalDataDao.list();
        assertNotNull("List should not be null", result);
    }

}
