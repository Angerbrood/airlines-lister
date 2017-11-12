package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.UserProfileDao;
import edu.elte.airlines.factory.domain.UserProfileFactory;
import edu.elte.airlines.model.UserProfile;
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
public class UserProfileDaoTest {
    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private UserProfileFactory userProfileFactory;

    private UserProfile userProfileToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", userProfileDao);
        userProfileToModifyOrDelete = userProfileFactory.createOne();
        userProfileDao.persist(userProfileToModifyOrDelete);
        assertNotNull("Id should not be null after save", userProfileToModifyOrDelete.getId());
    }


    @Test
    public void testSave() {
        UserProfile user = userProfileFactory.createOne();
        assertNull("Id should be null before save", user.getId());
        user.setType("TEMP_PRIVILAGE");
        userProfileDao.persist(user);
        assertNotNull("Id should not be null after save", user.getId());
    }
    @Test
    public void testFindById() {
        int id = userProfileToModifyOrDelete.getId();
        UserProfile userPersonalData = userProfileDao.findById(id);
        assertNotNull("Airline should not be null", userPersonalData);
    }
    @Test
    public void testUpdate() {
        userProfileToModifyOrDelete.setType("updated");
        assertNotNull("Id should not be null before update", userProfileToModifyOrDelete.getId());
        userProfileDao.update(userProfileToModifyOrDelete);

    }
    @Test
    public void testDelete() {
        assertNotNull("Id should not be null before update", userProfileToModifyOrDelete.getId());
        userProfileDao.delete(userProfileToModifyOrDelete);
    }
    @Test
    public void testList() {
        List<UserProfile> result = userProfileDao.list();
        assertNotNull("List should not be null", result);
    }


}
