package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserProfileDao;
import edu.elte.airlines.factory.domain.UserProfileFactory;
import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserProfileService;
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
public class UserProfileServiceTest extends AbstractServiceTest<UserProfile> {

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserProfileFactory userProfileFactory;


    @Override
    protected CrudService<Integer, UserProfile> getService() {
        return userProfileService;
    }

    @Override
    protected CrudDao<Integer, UserProfile> getDao() {
        return userProfileDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<UserProfile> getEntityClass() {
        return UserProfile.class;
    }

    @Override
    protected UserProfile createEntity(boolean withId) {
        UserProfile result = userProfileFactory.createOne();
        if(withId) {
            result.setId(1);
        }
        return result;
    }
}
