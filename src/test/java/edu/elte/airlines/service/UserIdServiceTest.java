package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.factory.domain.UserIdFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.UserIdService;
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
public class UserIdServiceTest extends AbstractServiceTest<UserId, UserIdDto> {
    @Autowired
    private UserIdService userIdService;
    @Autowired
    private UserIdDao userIdDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserIdFactory userIdFactory;
    @Override
    protected CrudService<UserId, UserIdDto, Integer> getService() {
        return userIdService;
    }

    @Override
    protected CrudDao<UserId, Integer> getDao() {
        return userIdDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<UserId> getEntityClass() {
        return UserId.class;
    }

    @Override
    protected UserId createEntity(boolean withId) {
        UserId userId = userIdFactory.createOne();
        if(withId) {
            userId.setId(1);
        }
        return userId;
    }

    @Override
    protected UserIdDto createDto() {
        return new UserIdDto();
    }
}
