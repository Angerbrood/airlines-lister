package edu.elte.airlines.integration;

import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.dto.UserPersonalDataDtoFactory;
import edu.elte.airlines.integration.configuration.IntegrationTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;
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
public class UserPersonalDataTest extends AbstractIntegrationTest<UserPersonalData, UserPersonalDataDto, Integer> {
    private static Logger logger = LoggerFactory.getLogger(UserPersonalDataTest.class);

    @Autowired
    private UserPersonalDataService userPersonalDataService;
    @Autowired
    private UserPersonalDataDtoFactory userPersonalDataDtoFactory;
    private UserPersonalDataDto userPersonalDataDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        userPersonalDataDto = userPersonalDataDtoFactory.createOne();
        userPersonalDataDto.setId(getService().create(userPersonalDataDto));
        logger.info("Database prepared!");
    }

    @Override
    protected CrudService<UserPersonalData, UserPersonalDataDto, Integer> getService() {
        return userPersonalDataService;
    }

    @Override
    protected AbstractDtoFactory<UserPersonalData, UserPersonalDataDto, Integer> getFactory() {
        return userPersonalDataDtoFactory;
    }

    @Override
    protected UserPersonalDataDto getDto() {
        return userPersonalDataDto;
    }
}
