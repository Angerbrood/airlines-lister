package edu.elte.airlines.configuration;

import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.response.CustomResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import static org.mockito.Mockito.mock;

@Configuration
public class MockedDaoContext {
    @Bean
    AirlineDao airlineDao() {
        return mock(AirlineDao.class);
    }
    @Bean
    FlightDao flightDao() {
        return mock(FlightDao.class);
    }
    @Bean
    LocationDao locationDao() {
        return mock(LocationDao.class);
    }
    @Bean
    UserDetailDao userDetailDao() {
        return mock(UserDetailDao.class);
    }
    @Bean
    UserAuthDao userAuthDao() {
        return mock(UserAuthDao.class);
    }
    @Bean
    UserIdDao userIdDao() {
        return mock(UserIdDao.class);
    }
    @Bean
    public ConversionService conversionService() {
        return mock(ConversionService.class);
    }
    @Bean
    public CustomResponseFactory customResponseFactory() {
        return mock(CustomResponseFactory.class);
    }
}
