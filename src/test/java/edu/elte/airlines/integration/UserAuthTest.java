package edu.elte.airlines.integration;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.UserAuthDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserAuthService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class UserAuthTest extends AbstractIntegrationTest<UserAuth, UserAuthDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(UserAuthTest.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserAuthDtoFactory userAuthDtoFactory;
    private UserAuthDto userAuthDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        userAuthDto = userAuthDtoFactory.createOne();
        userAuthDto.setId(getService().create(userAuthDto));
        logger.info("Database prepared!");
    }


    @Override
    protected CrudService<UserAuth, UserAuthDto, Integer> getService() {
        return (UserAuthService) userDetailsService;
    }

    @Override
    protected AbstractDtoFactory<UserAuth, UserAuthDto, Integer> getFactory() {
        return userAuthDtoFactory;
    }

    @Override
    protected UserAuthDto getDto() {
        return userAuthDto;
    }
}
