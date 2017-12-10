package edu.elte.airlines.dao;

import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.factory.domain.UserFactory;
import edu.elte.airlines.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
@WebAppConfiguration
public class UserDaoTest {
    @Autowired
    private UserFactory userFactory;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PassengerDao passengerDao;
    private User userToModifyOrDelete;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", userDao);
        userToModifyOrDelete = userFactory.createOne();
        passengerDao.persist(userToModifyOrDelete.getUserPassengerData());
        userDao.save(userToModifyOrDelete);
        assertNotNull("Id should not be null after save", userToModifyOrDelete.getId());
    }


    @Test
    public void nonNullUserCreationSuccess() {
        User user = userFactory.createOne();
        assertNull("Id should be null before save", user.getId());
        passengerDao.persist(user.getUserPassengerData());
        userDao.save(user);
        assertNotNull("Id should not be null after save", user.getId());
    }
    @Test
    public void nonNullUserIdFound() {
        int id = userToModifyOrDelete.getId();
        User userPersonalData = userDao.findById(id);
        assertNotNull("Airline should not be null", userPersonalData);
    }
    @Test
    public void nonNullUserUpdateSuccess() {
        userToModifyOrDelete.getUserPassengerData().setEmail("updated");
        assertNotNull("Id should not be null before update", userToModifyOrDelete.getId());
        userDao.update(userToModifyOrDelete);

    }
    @Test
    public void nonNullUserDeleteSuccess() {
        assertNotNull("Id should not be null before update", userToModifyOrDelete.getId());
        userDao.delete(userToModifyOrDelete);
    }
    @Test
    public void usersListSuccess() {
        Collection<User> result = userDao.list();
        assertNotNull("List should not be null", result);
    }

}
