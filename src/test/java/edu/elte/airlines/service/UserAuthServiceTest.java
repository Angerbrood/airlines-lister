package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.factory.domain.UserAuthFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserAuthService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class UserAuthServiceTest  extends AbstractServiceTest<UserAuth, UserAuthDto> {
    @Autowired
    private UserDetailsService userAuthService;
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserAuthFactory userAuthFactory;


    @Override
    protected CrudService<UserAuth, UserAuthDto, Integer> getService() {
        return (CrudService) userAuthService;
    }

    @Override
    protected CrudDao<UserAuth, Integer> getDao() {
        return userAuthDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<UserAuth> getEntityClass() {
        return UserAuth.class;
    }

    @Override
    protected UserAuth createEntity(boolean withId) {
        UserAuth userAuth = userAuthFactory.createOne();
        if(withId) {
            userAuth.setId(1);
        }
        return userAuth;
    }

    @Override
    protected UserAuthDto createDto() {
        return new UserAuthDto();
    }
}
