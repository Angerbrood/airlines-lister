package edu.elte.airlines.dao;


import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.factory.domain.UserAuthFactory;
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
public class UserAuthDaoTest {
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserAuthFactory userAuthFactory;

    private UserAuth airlineToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", userAuthDao);
        airlineToModifyOrDelete = userAuthFactory.createOne();
        userAuthDao.createEntity(airlineToModifyOrDelete);
        assertNotNull("Id should not be null after save", airlineToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        UserAuth userAuth = userAuthFactory.createOne();
        assertNull("Id should be null before save", userAuth.getId());
        userAuthDao.createEntity(userAuth);
        assertNotNull("Id should not be null after save", userAuth.getId());
    }
    @Test
    public void testFindById() {
        int id = airlineToModifyOrDelete.getId();
        UserAuth userAuth = userAuthDao.findById(id);
        assertNotNull("Airline should not be null", userAuth);
    }
    @Test
    public void testUpdate() {
        airlineToModifyOrDelete.setUsername("updated");
        assertNotNull("Id should not be null before update", airlineToModifyOrDelete.getId());
        userAuthDao.updateEntity(airlineToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", airlineToModifyOrDelete.getId());
        userAuthDao.deleteEntity(airlineToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<UserAuth> result = userAuthDao.list();
        assertNotNull("List should not be null", result);
    }
}
