package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserDao;
import edu.elte.airlines.factory.domain.UserFactory;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
@WebAppConfiguration
public class UserServiceTest extends AbstractServiceTest<User> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserFactory userFactory;
    @Override
    protected CrudService<Integer, User> getService() {
        return userService;
    }

    @Override
    protected CrudDao<Integer, User> getDao() {
        return userDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected User createEntity(boolean withId) {
        User result = userFactory.createOne();
        if(withId) {
            result.setId(1);
        }
        return result;
    }
}
