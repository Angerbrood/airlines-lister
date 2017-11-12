package edu.elte.airlines.integration;

import edu.elte.airlines.configuration.ApplicationConfig;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.factory.domain.UserFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class UserTest extends AbstractIntegrationTest<User, Integer> {
    private static Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserFactory userFactory;
    private User user;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        user = userFactory.createOne();
        userService.saveUser(user);
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<Integer, User> getService() {
        return userService;
    }

    @Override
    protected AbstractFactory<User> getFactory() {
        return userFactory;
    }

    @Override
    protected User getEntity() {
        return user;
    }
}
