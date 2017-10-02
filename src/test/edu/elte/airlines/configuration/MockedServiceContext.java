package edu.elte.airlines.configuration;

import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.service.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockedServiceContext {
    @Bean
    AirlineService airlineService() {
        return mock(AirlineService.class);
    }
    @Bean
    FlightService flightService() {
        return mock(FlightService.class);
    }
    @Bean
    LocationService locationService() {
        return mock(LocationService.class);
    }
    @Bean
    UserDetailService userDetailService() {
        return mock(UserDetailService.class);
    }
    @Bean
    UserAuthService userAuthService() {
        return mock(UserAuthService.class);
    }
    @Bean
    UserIdService userIdService() {
        return mock(UserIdService.class);
    }
}
