package edu.elte.airlines.configuration;

import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.response.CustomResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    PassengerDao passengerDao() {
        return mock(PassengerDao.class);
    }
    @Bean
    UserDao userDao() {
        return mock(UserDao.class);
    }
    @Bean
    UserProfileDao userProfileDao() {
        return mock(UserProfileDao.class);
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
