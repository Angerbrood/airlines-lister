package edu.elte.airlines.integration;

import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.UserIdDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserIdService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class UserIdTest extends AbstractIntegrationTest<UserId, UserIdDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(UserIdTest.class);

    @Autowired
    private UserIdService userIdService;
    @Autowired
    private UserIdDtoFactory userIdDtoFactory;
    private UserIdDto userIdDto;


    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        userIdDto = userIdDtoFactory.createOne();
        userIdDto.setId(getService().create(userIdDto));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<UserId, UserIdDto, Integer> getService() {
        return userIdService;
    }

    @Override
    protected AbstractDtoFactory<UserId, UserIdDto, Integer> getFactory() {
        return userIdDtoFactory;
    }

    @Override
    protected UserIdDto getDto() {
        return userIdDto;
    }
}
