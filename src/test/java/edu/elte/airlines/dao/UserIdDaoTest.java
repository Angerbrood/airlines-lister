package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.factory.domain.UserIdFactory;
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
public class UserIdDaoTest {
    @Autowired
    private UserIdDao userAuthDao;
    @Autowired
    private UserIdFactory userAuthFactory;

    private UserId userIdToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", userAuthDao);
        userIdToModifyOrDelete = userAuthFactory.createOne();
        userAuthDao.createEntity(userIdToModifyOrDelete);
        assertNotNull("Id should not be null after save", userIdToModifyOrDelete.getId());
    }

    @Test
    public void testSave() {
        UserId userAuth = userAuthFactory.createOne();
        assertNull("Id should be null before save", userAuth.getId());
        userAuthDao.createEntity(userAuth);
        assertNotNull("Id should not be null after save", userAuth.getId());
    }
    @Test
    public void testFindById() {
        int id = userIdToModifyOrDelete.getId();
        UserId userAuth = userAuthDao.findById(id);
        assertNotNull("Airline should not be null", userAuth);
    }
    @Test
    public void testUpdate() {
        assertNotNull("Id should not be null before update", userIdToModifyOrDelete.getId());
        userAuthDao.updateEntity(userIdToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", userIdToModifyOrDelete.getId());
        userAuthDao.deleteEntity(userIdToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<UserId> result = userAuthDao.list();
        assertNotNull("List should not be null", result);
    }
}
