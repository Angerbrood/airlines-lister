package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserPersonalDataDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.domain.UserPersonalDataFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class UserPersonalDataServiceTest extends AbstractServiceTest<UserPersonalData, UserPersonalDataDto> {
    @Autowired
    private UserPersonalDataService userPersonalDataService;
    @Autowired
    private UserPersonalDataDao userPersonalDataDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserPersonalDataFactory userPersonalDataFactory;
    @Override
    protected CrudService<UserPersonalData, UserPersonalDataDto, Integer> getService() {
        return userPersonalDataService;
    }

    @Override
    protected CrudDao<UserPersonalData, Integer> getDao() {
        return userPersonalDataDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<UserPersonalData> getEntityClass() {
        return UserPersonalData.class;
    }

    @Override
    protected UserPersonalData createEntity(boolean withId) {
        UserPersonalData personalData = userPersonalDataFactory.createOne();
        if(withId) {
            personalData.setId(1);
        }
        return personalData;
    }

    @Override
    protected UserPersonalDataDto createDto() {
        return new UserPersonalDataDto();
    }
}
